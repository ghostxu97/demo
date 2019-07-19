package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 库存出入库记录表 sys_stock_record
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
public class StockRecord extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	public static final int RECORD_TYPE_OUT = 1;
	public static final int RECORD_TYPE_IN = 0;
	

	/** 出入库记录编号 */
	@Excel(name = "出入库编号")
	private Long recordId;
	
	/** 货品编号 */
	private Long goodsId;
	
	/** 货品名称 */
	@Excel(name = "货品名称")
	private String nameSpec;
	
	/** 计价 数量*价格  */
	@Excel(name = "计价")
	private String amountPrice;
	
	/** 出入库类型 1-出货 0-进货 */
	@Excel(name = "出入库类型", readConverterExp = "0=进货,1=出货")
	private Integer type;
	
	/** 出入库之前数量 */
	@Excel(name = "出入库之前数量")
	private Long beforeStock;
	
	/** 出入库之前数量 */
	@Excel(name = "出入库之前数量")
	private Long afterStock;
	
	/** 交易金额 */
	@Excel(name = "该次交易金额")
	private BigDecimal totalMoney;
	
	/** 交易方ID */
	private Long traderId;
	
	/** 交易方姓名 */
	@Excel(name = "该次交易方姓名")
	private String traderName;
	
	/** 操作时间 */
	@Excel(name = "操作时间")
	private Date operateTime;

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setBeforeStock(Long beforeStock) {
		this.beforeStock = beforeStock;
	}

	public Long getBeforeStock() {
		return beforeStock;
	}

	public void setAfterStock(Long afterStock) {
		this.afterStock = afterStock;
	}

	public Long getAfterStock() {
		return afterStock;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}

	public Long getTraderId() {
		return traderId;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public String getTraderName() {
		return traderName;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public String getNameSpec() {
		return nameSpec;
	}

	public void setNameSpec(String nameSpec) {
		this.nameSpec = nameSpec;
	}

	public String getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(String amountPrice) {
		this.amountPrice = amountPrice;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("recordId", getRecordId())
				.append("goodsId", getGoodsId()).append("nameSpec", getNameSpec()).append("amountPrice", getAmountPrice())
				.append("type", getType()).append("beforeStock", getBeforeStock()).append("afterStock", getAfterStock())
				.append("totalMoney", getTotalMoney()).append("traderId", getTraderId())
				.append("traderName", getTraderName()).append("operateTime", getOperateTime()).toString();
	}
}
