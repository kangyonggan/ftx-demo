package com.kangyonggan.ftx.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kyg
 */
@Data
public class Account implements Serializable {

    /**
     * 该账户是否为是注册的流动性支持提供者
     */
    private Boolean backstopProvider;

    /**
     * 抵押金额
     */
    private BigDecimal collateral;

    /**
     * 免费抵押金额
     */
    private BigDecimal freeCollateral;

    /**
     * 单个期货品种的 initialMarginRequirement（初始保证金要求），按名义头寸加权。 如果 openMarginFraction（开仓保证金比例）低于该值则无法新开头寸。
     */
    private BigDecimal initialMarginRequirement;

    /**
     * 如果账户正在清算则为是
     */
    private Boolean liquidating;

    /**
     * 单个期货品种的 maintenanceMarginRequirement（持仓保证金要求）平均金额，按名义头寸加权。 如果保证金比例低于该值，则进入清算模式。
     */
    private BigDecimal maintenanceMarginRequirement;

    /**
     * 挂单费
     */
    private BigDecimal makerFee;

    /**
     * 账户总值和账户名义头寸总额之比
     */
    private BigDecimal marginFraction;

    /**
     * 已实现账户价值总额和已建立名义头寸总额之比
     */
    private BigDecimal openMarginFraction;

    /**
     * 吃单费
     */
    private BigDecimal takerFee;

    /**
     * 以头寸标记价格计算的账户总值
     */
    private BigDecimal totalAccountValue;

    /**
     * 以标记价格计算的账户持有头寸总额
     */
    private BigDecimal totalPositionSize;

    /**
     * 用户名，如：user@domain.com
     */
    private String username;

    /**
     * Max account leverage
     */
    private Boolean leverage;

    /**
     * See Get positions for details
     */
    private List<Position> positions;

}
