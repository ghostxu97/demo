package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 库存货品表 sys_stock_goods
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
public class StockGoods extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 货品编号 */
	@Excel(name = "货品编号")
	private Long goodsId;
	
	/** 货品名称 */
	@Excel(name = "货品名称")
	private String goodsName;
	
	/** 货品规格 */
	@Excel(name = "货品规格")
	private String spec;
	
	/** 货品单位 */
	@Excel(name = "货品单位")
	private String unit;
	
	/** 货品单价 */
	@Excel(name = "货品单价")
	private BigDecimal price;
	
	/** 货品存量 */
	@Excel(name = "货品存量")
	private Long inventory;
	
	/** 创建用户ID */
	private Long createId;
	
	/** 最后修改用户ID */
	private Long updateId;

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpec() {
		return spec;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}

	public Long getInventory() {
		return inventory;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("goodsId", getGoodsId())
				.append("goodsName", getGoodsName()).append("spec", getSpec()).append("unit", getUnit())
				.append("price", getPrice()).append("inventory", getInventory()).append("createTime", getCreateTime())
				.append("createBy", getCreateBy()).append("createId", getCreateId())
				.append("updateTime", getUpdateTime()).append("updateBy", getUpdateBy())
				.append("updateId", getUpdateId()).toString();
	}
}
