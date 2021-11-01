package com.kangyonggan.ftx.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kyg
 */
@Data
public class Order implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间。格式："2019-03-05T09:56:55.728933+00:00"
     */
    private String createdAt;

    /**
     * 期货。XRP-PERP
     */
    private String future;

    /**
     * 行情。XRP-PERP
     */
    private String market;

    /**
     * 买卖方向。sell：卖。buy：买
     */
    private String side;

    /**
     * 订单类型。limit：限价单
     */
    private String type;

    /**
     * 只减仓
     */
    private Boolean reduceOnly;

    /**
     * ioc
     */
    private Boolean ioc;

    /**
     * postOnly
     */
    private Boolean postOnly;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 数量
     */
    private BigDecimal size;

    /**
     * 状态
     */
    private String status;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 成交均价
     */
    private BigDecimal avgFillPrice;

    /**
     * 成交量
     */
    private BigDecimal filledSize;

    /**
     * 未成交数量
     */
    private BigDecimal remainingSize;

}
