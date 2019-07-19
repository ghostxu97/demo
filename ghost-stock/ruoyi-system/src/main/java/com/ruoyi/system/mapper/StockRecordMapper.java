package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.StockRecord;
import java.util.List;

/**
 * 库存出入库记录 数据层
 * 
 * @author ghostxu
 * @date 2019-07-16
 */
public interface StockRecordMapper {
	/**
	 * 查询库存出入库记录信息
	 * 
	 * @param recordId
	 *            库存出入库记录ID
	 * @return 库存出入库记录信息
	 */
	public StockRecord selectStockRecordById(Long recordId);

	/**
	 * 查询库存出入库记录列表
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 库存出入库记录集合
	 */
	public List<StockRecord> selectStockRecordList(StockRecord stockRecord);

	/**
	 * 新增库存出入库记录
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 结果
	 */
	public int insertStockRecord(StockRecord stockRecord);

	/**
	 * 修改库存出入库记录
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 结果
	 */
	public int updateStockRecord(StockRecord stockRecord);

	/**
	 * 删除库存出入库记录
	 * 
	 * @param recordId
	 *            库存出入库记录ID
	 * @return 结果
	 */
	public int deleteStockRecordById(Long recordId);

	/**
	 * 批量删除库存出入库记录
	 * 
	 * @param recordIds
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteStockRecordByIds(String[] recordIds);

}