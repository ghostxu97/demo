package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StockGoodsMapper;
import com.ruoyi.system.domain.StockGoods;
import com.ruoyi.system.service.IStockGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存货品 服务层实现
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
@Service
public class StockGoodsServiceImpl implements IStockGoodsService 
{
	@Autowired
	private StockGoodsMapper stockGoodsMapper;

	/**
     * 查询库存货品信息
     * 
     * @param goodsId 库存货品ID
     * @return 库存货品信息
     */
    @Override
	public StockGoods selectStockGoodsById(Long goodsId)
	{
	    return stockGoodsMapper.selectStockGoodsById(goodsId);
	}
	
	/**
     * 查询库存货品列表
     * 
     * @param stockGoods 库存货品信息
     * @return 库存货品集合
     */
	@Override
	public List<StockGoods> selectStockGoodsList(StockGoods stockGoods)
	{
	    return stockGoodsMapper.selectStockGoodsList(stockGoods);
	}
	
    /**
     * 新增库存货品
     * 
     * @param stockGoods 库存货品信息
     * @return 结果
     */
	@Override
	public int insertStockGoods(StockGoods stockGoods)
	{
	    return stockGoodsMapper.insertStockGoods(stockGoods);
	}
	
	/**
     * 修改库存货品
     * 
     * @param stockGoods 库存货品信息
     * @return 结果
     */
	@Override
	public int updateStockGoods(StockGoods stockGoods)
	{
	    return stockGoodsMapper.updateStockGoods(stockGoods);
	}

	/**
     * 删除库存货品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStockGoodsByIds(String ids)
	{
		return stockGoodsMapper.deleteStockGoodsByIds(Convert.toStrArray(ids));
	}
	
}
