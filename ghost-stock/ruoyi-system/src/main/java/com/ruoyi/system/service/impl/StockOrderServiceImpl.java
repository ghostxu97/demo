package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StockOrderMapper;
import com.ruoyi.system.domain.StockOrder;
import com.ruoyi.system.service.IStockOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存交易订单 服务层实现
 * 
 * @author ghostxu
 * @date 2019-07-16
 */
@Service
public class StockOrderServiceImpl implements IStockOrderService {
	@Autowired
	private StockOrderMapper stockOrderMapper;

	/**
	 * 查询库存交易订单信息
	 * 
	 * @param orderId
	 *            库存交易订单ID
	 * @return 库存交易订单信息
	 */
	@Override
	public StockOrder selectStockOrderById(Long orderId) {
		return stockOrderMapper.selectStockOrderById(orderId);
	}

	/**
	 * 查询库存交易订单列表
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 库存交易订单集合
	 */
	@Override
	public List<StockOrder> selectStockOrderList(StockOrder stockOrder) {
		return stockOrderMapper.selectStockOrderList(stockOrder);
	}

	/**
	 * 新增库存交易订单
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 结果
	 */
	@Override
	public int insertStockOrder(StockOrder stockOrder) {
		return stockOrderMapper.insertStockOrder(stockOrder);
	}

	/**
	 * 修改库存交易订单
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 结果
	 */
	@Override
	public int updateStockOrder(StockOrder stockOrder) {
		return stockOrderMapper.updateStockOrder(stockOrder);
	}

	/**
	 * 删除库存交易订单对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteStockOrderByIds(String ids) {
		return stockOrderMapper.deleteStockOrderByIds(Convert.toStrArray(ids));
	}

}
