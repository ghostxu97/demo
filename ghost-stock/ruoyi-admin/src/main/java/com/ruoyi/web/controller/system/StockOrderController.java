package com.ruoyi.web.controller.system;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StockGoods;
import com.ruoyi.system.domain.StockOrder;
import com.ruoyi.system.domain.StockRecord;
import com.ruoyi.system.service.IStockGoodsService;
import com.ruoyi.system.service.IStockOrderService;
import com.ruoyi.system.service.IStockRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 库存交易订单 信息操作处理
 * 
 * @author ghostxu
 * @date 2019-07-15
 */
@Controller
@RequestMapping("/system/stockOrder")
public class StockOrderController extends BaseController {

	private String prefix = "system/stockOrder";

	@Autowired
	private IStockOrderService stockOrderService;

	@Autowired
	private IStockRecordService stockRecordService;

	private IStockGoodsService stockGoodsService;

	@RequiresPermissions("system:stockOrder:view")
	@GetMapping()
	public String stockOrder() {
		return prefix + "/stockOrder";
	}

	/**
	 * 查询库存交易订单列表
	 */
	@RequiresPermissions("system:stockOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(StockOrder stockOrder) {
		startPage();
		List<StockOrder> list = stockOrderService.selectStockOrderList(stockOrder);
		return getDataTable(list);
	}

	/**
	 * 导出库存交易订单列表
	 */
	@RequiresPermissions("system:stockOrder:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(StockOrder stockOrder) {
		List<StockOrder> list = stockOrderService.selectStockOrderList(stockOrder);
		ExcelUtil<StockOrder> util = new ExcelUtil<StockOrder>(StockOrder.class);
		return util.exportExcel(list, "stockOrder");
	}

	/**
	 * 新增库存交易订单
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存库存交易订单
	 */
	@RequiresPermissions("system:stockOrder:add")
	@Log(title = "库存交易订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(StockOrder stockOrder) {
		boolean result = false;
		result = updateStock(stockOrder);
		if (result) {
			int total = stockOrderService.insertStockOrder(stockOrder);
			result = total > 0 ? true : false;
		}
		return toAjax(result);
	}

	/**
	 * 修改库存交易订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap) {
		StockOrder stockOrder = stockOrderService.selectStockOrderById(orderId);
		mmap.put("stockOrder", stockOrder);
		return prefix + "/edit";
	}

	/**
	 * 修改保存库存交易订单
	 */
	@RequiresPermissions("system:stockOrder:edit")
	@Log(title = "库存交易订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(StockOrder stockOrder) {

		return toAjax(stockOrderService.updateStockOrder(stockOrder));
	}

	/**
	 * 删除库存交易订单
	 */
	@RequiresPermissions("system:stockOrder:remove")
	@Log(title = "库存交易订单", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(stockOrderService.deleteStockOrderByIds(ids));
	}

	/**
	 * 根据订单更新库存信息
	 */
	public boolean updateStock(StockOrder stockOrder) {
		boolean result = false;

		long goodsId = stockOrder.getGoodsId();
		StockGoods goods = stockGoodsService.selectStockGoodsById(goodsId);
		BigDecimal goodsPayment = stockOrder.getTradeMoney();
		long goodsAmount = stockOrder.getGoodsAmount();
		BigDecimal price = stockOrder.getGoodsPrice();

		long originalInventory = goods.getInventory();
		long afterInventory = originalInventory;

		int tradeType = stockOrder.getTradeType();
		switch (tradeType) {
		case StockOrder.TRADER_TYPE_SELL:
			afterInventory -= goodsAmount;
			break;
		case StockOrder.TRADER_TYPE_BUG:
			afterInventory += goodsAmount;
			break;
		default:
			break;
		}
		goods.setInventory(afterInventory);
		goods.setUpdateTime(new Date());
		goods.setUpdateBy(ShiroUtils.getSysUser().getUserName());
		goods.setUpdateId(ShiroUtils.getSysUser().getUserId());

		int total = stockGoodsService.updateStockGoods(goods);
		if (total > 0) {
			StockRecord record = new StockRecord();
			record.setGoodsId(goodsId);
			record.setNameSpec(goods.getGoodsName() + goods.getSpec());
			record.setAmountPrice(goodsAmount + "*" + price);
			record.setType(tradeType);
			record.setBeforeStock(originalInventory);
			record.setAfterStock(afterInventory);
			record.setTotalMoney(goodsPayment);
			record.setTraderId(stockOrder.getTraderId());
			record.setTraderName(stockOrder.getTraderName());
			record.setOperateTime(new Date());

			total = stockRecordService.updateStockRecord(record);
			result = total > 0 ? true : false;
		}

		return result;
	}

}
