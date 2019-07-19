package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.service.IStockGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 库存货品 信息操作处理
 * 
 * @author ghostxu
 * @date 2019-07-15
 */
@Controller
@RequestMapping("/system/stockGoods")
public class StockGoodsController extends BaseController
{
    private String prefix = "system/stockGoods";
	
	@Autowired
	private IStockGoodsService stockGoodsService;
	
	@RequiresPermissions("system:stockGoods:view")
	@GetMapping()
	public String stockGoods()
	{
	    return prefix + "/stockGoods";
	}
	
	/**
	 * 查询库存货品列表
	 */
	@RequiresPermissions("system:stockGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(StockGoods stockGoods)
	{
		startPage();
        List<StockGoods> list = stockGoodsService.selectStockGoodsList(stockGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出库存货品列表
	 */
	@RequiresPermissions("system:stockGoods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StockGoods stockGoods)
    {
    	List<StockGoods> list = stockGoodsService.selectStockGoodsList(stockGoods);
        ExcelUtil<StockGoods> util = new ExcelUtil<StockGoods>(StockGoods.class);
        return util.exportExcel(list, "stockGoods");
    }
	
	/**
	 * 新增库存货品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存库存货品
	 */
	@RequiresPermissions("system:stockGoods:add")
	@Log(title = "库存货品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(StockGoods stockGoods)
	{		
		return toAjax(stockGoodsService.insertStockGoods(stockGoods));
	}

	/**
	 * 修改库存货品
	 */
	@GetMapping("/edit/{goodsId}")
	public String edit(@PathVariable("goodsId") Long goodsId, ModelMap mmap)
	{
		StockGoods stockGoods = stockGoodsService.selectStockGoodsById(goodsId);
		mmap.put("stockGoods", stockGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存库存货品
	 */
	@RequiresPermissions("system:stockGoods:edit")
	@Log(title = "库存货品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(StockGoods stockGoods)
	{		
		return toAjax(stockGoodsService.updateStockGoods(stockGoods));
	}
	
	/**
	 * 删除库存货品
	 */
	@RequiresPermissions("system:stockGoods:remove")
	@Log(title = "库存货品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stockGoodsService.deleteStockGoodsByIds(ids));
	}
	
}
