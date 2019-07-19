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
import com.ruoyi.system.domain.StockRecord;
import com.ruoyi.system.service.IStockRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 库存出入库记录 信息操作处理
 * 
 * @author ghostxu
 * @date 2019-07-15
 */
@Controller
@RequestMapping("/system/stockRecord")
public class StockRecordController extends BaseController
{
    private String prefix = "system/stockRecord";
	
	@Autowired
	private IStockRecordService stockRecordService;
	
	@RequiresPermissions("system:stockRecord:view")
	@GetMapping()
	public String stockRecord()
	{
	    return prefix + "/stockRecord";
	}
	
	/**
	 * 查询库存出入库记录列表
	 */
	@RequiresPermissions("system:stockRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(StockRecord stockRecord)
	{
		startPage();
        List<StockRecord> list = stockRecordService.selectStockRecordList(stockRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出库存出入库记录列表
	 */
	@RequiresPermissions("system:stockRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StockRecord stockRecord)
    {
    	List<StockRecord> list = stockRecordService.selectStockRecordList(stockRecord);
        ExcelUtil<StockRecord> util = new ExcelUtil<StockRecord>(StockRecord.class);
        return util.exportExcel(list, "stockRecord");
    }
	
	/**
	 * 新增库存出入库记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存库存出入库记录
	 */
	@RequiresPermissions("system:stockRecord:add")
	@Log(title = "库存出入库记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(StockRecord stockRecord)
	{		
		return toAjax(stockRecordService.insertStockRecord(stockRecord));
	}

	/**
	 * 修改库存出入库记录
	 */
	@GetMapping("/edit/{recordId}")
	public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
	{
		StockRecord stockRecord = stockRecordService.selectStockRecordById(recordId);
		mmap.put("stockRecord", stockRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存库存出入库记录
	 */
	@RequiresPermissions("system:stockRecord:edit")
	@Log(title = "库存出入库记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(StockRecord stockRecord)
	{		
		return toAjax(stockRecordService.updateStockRecord(stockRecord));
	}
	
	/**
	 * 删除库存出入库记录
	 */
	@RequiresPermissions("system:stockRecord:remove")
	@Log(title = "库存出入库记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stockRecordService.deleteStockRecordByIds(ids));
	}
	
}
