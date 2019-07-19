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
import com.ruoyi.system.domain.StockTrader;
import com.ruoyi.system.service.IStockTraderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 库存交易方 信息操作处理
 * 
 * @author ghostxu
 * @date 2019-07-15
 */
@Controller
@RequestMapping("/system/stockTrader")
public class StockTraderController extends BaseController
{
    private String prefix = "system/stockTrader";
	
	@Autowired
	private IStockTraderService stockTraderService;
	
	@RequiresPermissions("system:stockTrader:view")
	@GetMapping()
	public String stockTrader()
	{
	    return prefix + "/stockTrader";
	}
	
	/**
	 * 查询库存交易方列表
	 */
	@RequiresPermissions("system:stockTrader:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(StockTrader stockTrader)
	{
		startPage();
        List<StockTrader> list = stockTraderService.selectStockTraderList(stockTrader);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出库存交易方列表
	 */
	@RequiresPermissions("system:stockTrader:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StockTrader stockTrader)
    {
    	List<StockTrader> list = stockTraderService.selectStockTraderList(stockTrader);
        ExcelUtil<StockTrader> util = new ExcelUtil<StockTrader>(StockTrader.class);
        return util.exportExcel(list, "stockTrader");
    }
	
	/**
	 * 新增库存交易方
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存库存交易方
	 */
	@RequiresPermissions("system:stockTrader:add")
	@Log(title = "库存交易方", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(StockTrader stockTrader)
	{		
		return toAjax(stockTraderService.insertStockTrader(stockTrader));
	}

	/**
	 * 修改库存交易方
	 */
	@GetMapping("/edit/{traderId}")
	public String edit(@PathVariable("traderId") Long traderId, ModelMap mmap)
	{
		StockTrader stockTrader = stockTraderService.selectStockTraderById(traderId);
		mmap.put("stockTrader", stockTrader);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存库存交易方
	 */
	@RequiresPermissions("system:stockTrader:edit")
	@Log(title = "库存交易方", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(StockTrader stockTrader)
	{		
		return toAjax(stockTraderService.updateStockTrader(stockTrader));
	}
	
	/**
	 * 删除库存交易方
	 */
	@RequiresPermissions("system:stockTrader:remove")
	@Log(title = "库存交易方", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stockTraderService.deleteStockTraderByIds(ids));
	}
	
}
