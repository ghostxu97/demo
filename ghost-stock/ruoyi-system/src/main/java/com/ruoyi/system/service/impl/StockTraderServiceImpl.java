package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StockTraderMapper;
import com.ruoyi.system.domain.StockTrader;
import com.ruoyi.system.service.IStockTraderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存交易方 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
@Service
public class StockTraderServiceImpl implements IStockTraderService 
{
	@Autowired
	private StockTraderMapper stockTraderMapper;

	/**
     * 查询库存交易方信息
     * 
     * @param traderId 库存交易方ID
     * @return 库存交易方信息
     */
    @Override
	public StockTrader selectStockTraderById(Long traderId)
	{
	    return stockTraderMapper.selectStockTraderById(traderId);
	}
	
	/**
     * 查询库存交易方列表
     * 
     * @param stockTrader 库存交易方信息
     * @return 库存交易方集合
     */
	@Override
	public List<StockTrader> selectStockTraderList(StockTrader stockTrader)
	{
	    return stockTraderMapper.selectStockTraderList(stockTrader);
	}
	
    /**
     * 新增库存交易方
     * 
     * @param stockTrader 库存交易方信息
     * @return 结果
     */
	@Override
	public int insertStockTrader(StockTrader stockTrader)
	{
	    return stockTraderMapper.insertStockTrader(stockTrader);
	}
	
	/**
     * 修改库存交易方
     * 
     * @param stockTrader 库存交易方信息
     * @return 结果
     */
	@Override
	public int updateStockTrader(StockTrader stockTrader)
	{
	    return stockTraderMapper.updateStockTrader(stockTrader);
	}

	/**
     * 删除库存交易方对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStockTraderByIds(String ids)
	{
		return stockTraderMapper.deleteStockTraderByIds(Convert.toStrArray(ids));
	}
	
}
