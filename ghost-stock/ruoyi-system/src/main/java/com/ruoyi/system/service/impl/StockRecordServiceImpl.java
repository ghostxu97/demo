package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StockRecordMapper;
import com.ruoyi.system.domain.StockRecord;
import com.ruoyi.system.service.IStockRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存出入库记录 服务层实现
 * 
 * @author ghostxu
 * @date 2019-07-16
 */
@Service
public class StockRecordServiceImpl implements IStockRecordService {
	@Autowired
	private StockRecordMapper stockRecordMapper;

	/**
	 * 查询库存出入库记录信息
	 * 
	 * @param recordId
	 *            库存出入库记录ID
	 * @return 库存出入库记录信息
	 */
	@Override
	public StockRecord selectStockRecordById(Long recordId) {
		return stockRecordMapper.selectStockRecordById(recordId);
	}

	/**
	 * 查询库存出入库记录列表
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 库存出入库记录集合
	 */
	@Override
	public List<StockRecord> selectStockRecordList(StockRecord stockRecord) {
		return stockRecordMapper.selectStockRecordList(stockRecord);
	}

	/**
	 * 新增库存出入库记录
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 结果
	 */
	@Override
	public int insertStockRecord(StockRecord stockRecord) {
		return stockRecordMapper.insertStockRecord(stockRecord);
	}

	/**
	 * 修改库存出入库记录
	 * 
	 * @param stockRecord
	 *            库存出入库记录信息
	 * @return 结果
	 */
	@Override
	public int updateStockRecord(StockRecord stockRecord) {
		return stockRecordMapper.updateStockRecord(stockRecord);
	}

	/**
	 * 删除库存出入库记录对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteStockRecordByIds(String ids) {
		return stockRecordMapper.deleteStockRecordByIds(Convert.toStrArray(ids));
	}

}
