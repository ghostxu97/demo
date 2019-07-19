package com.ruoyi.system.service;

import com.ruoyi.system.domain.StockOrder;
import java.util.List;

/**
 * 库存交易订单 服务层
 * 
 * @author ghostxu
 * @date 2019-07-16
 */
public interface IStockOrderService {
	/**
	 * 查询库存交易订单信息
	 * 
	 * @param orderId
	 *            库存交易订单ID
	 * @return 库存交易订单信息
	 */
	public StockOrder selectStockOrderById(Long orderId);

	/**
	 * 查询库存交易订单列表
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 库存交易订单集合
	 */
	public List<StockOrder> selectStockOrderList(StockOrder stockOrder);

	/**
	 * 新增库存交易订单
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 结果
	 */
	public int insertStockOrder(StockOrder stockOrder);

	/**
	 * 修改库存交易订单
	 * 
	 * @param stockOrder
	 *            库存交易订单信息
	 * @return 结果
	 */
	public int updateStockOrder(StockOrder stockOrder);

	/**
	 * 删除库存交易订单信息
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteStockOrderByIds(String ids);

}
