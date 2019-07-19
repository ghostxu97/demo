package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 库存交易方表 sys_stock_trader
 * 
 * @author ruoyi
 * @date 2019-07-15
 */
public class StockTrader extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 交易方ID */
	@Excel(name = "交易方编号")
	private Long traderId;
	/** 交易方名称 */
	@Excel(name = "交易方名称")
	private String traderName;
	/** 备注名 */
	@Excel(name = "备注名")
	private String nickname;
	/** 结欠金额 */
	@Excel(name = "结欠金额")
	private BigDecimal balanceDue;
	/** 手机号 */
	@Excel(name = "手机号码")
	private String phone;
	/** 联系地址 */
	@Excel(name = "联系地址")
	private String address;
	/** 创建人ID */
	private Long createId;
	/** 更新人ID */
	private Long updateId;

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

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setBalanceDue(BigDecimal balanceDue) {
		this.balanceDue = balanceDue;
	}

	public BigDecimal getBalanceDue() {
		return balanceDue;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("traderId", getTraderId())
				.append("traderName", getTraderName()).append("nickname", getNickname())
				.append("balanceDue", getBalanceDue()).append("phone", getPhone()).append("address", getAddress())
				.append("createBy", getCreateBy()).append("createId", getCreateId())
				.append("createTime", getCreateTime()).append("updateId", getUpdateId())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).toString();
	}
}
