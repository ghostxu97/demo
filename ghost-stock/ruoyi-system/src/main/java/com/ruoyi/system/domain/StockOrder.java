package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 库存交易订单表 sys_stock_order
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
public class StockOrder extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	public static final int TRADER_TYPE_SELL = 1;
	public static final int TRADER_TYPE_BUG = 0;

	/** 交易信息编号 */
	@Excel(name = "交易信息编号")
	private Long orderId;
	
	/** 交易方ID */
	@Excel(name = "交易方编号")
	private Long traderId;
	
	/** 交易方姓名 */
	@Excel(name = "交易方姓名")
	private String traderName;
	
	/** 交易商品编号 */
	@Excel(name = "交易商品编号")
	private Long goodsId;

	/** 交易商品 */
	@Excel(name = "交易商品")
	private String goodsName;
	
	/**
	 * 交易商品单价
	 */
	@Excel(name = "商品单价")
	private BigDecimal goodsPrice;
	
	/**
	 * 交易商品数量
	 */
	@Excel(name = "数量")
	private long goodsAmount;
	
	/** 出入库记录编号 */
	@Excel(name = "出入库记录编号")
	private Long recordId;
	
	/** 交易类型 0-购买 1-售出 3-还款 */
	private Integer tradeType;
	
	/** 交易备注 */
	@Excel(name = "交易备注")
	private String tradeComment;
	
	/** 交易金额 */
	@Excel(name = "交易金额")
	private BigDecimal tradeMoney;
	
	/** 支付方式 0-赊账 1-微信 2-支付宝 3-银行卡 4-现金 */
	@Excel(name = "支付方式", readConverterExp = "0=赊账,1=微信,2=支付宝,3=银行卡,4=现金")
	private Integer payType;
	
	/** 结欠金额 */
	@Excel(name = "结欠金额")
	private BigDecimal blanceDue;
	
	/** 交易时间 */
	@Excel(name = "交易时间")
	private Date tradeTime;
	

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return orderId;
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeComment(String tradeComment) {
		this.tradeComment = tradeComment;
	}

	public String getTradeComment() {
		return tradeComment;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setBlanceDue(BigDecimal blanceDue) {
		this.blanceDue = blanceDue;
	}

	public BigDecimal getBlanceDue() {
		return blanceDue;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Date getTradeTime() {
		return tradeTime;
	}
	
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public long getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(long goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("orderId", getOrderId())
				.append("traderId", getTraderId()).append("traderName", getTraderName())
				.append("goodsId", getGoodsId()).append("goodsName", getGoodsName()).append("goodsPrice", getGoodsPrice()).append("goodsAmount", getGoodsAmount())
				.append("recordId", getRecordId()).append("tradeType", getTradeType()).append("tradeComment", getTradeComment())
				.append("tradeMoney", getTradeMoney()).append("payType", getPayType())
				.append("blanceDue", getBlanceDue()).append("tradeTime", getTradeTime()).toString();
	}
}
