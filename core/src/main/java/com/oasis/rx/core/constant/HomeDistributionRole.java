package com.oasis.rx.core.constant;

/**
 * 送药到家配送方式的规则
 */
public interface HomeDistributionRole {

    //大于等于
    String ROLE_GREATER = "1001";
    //小于
    String ROLE_LESS = "1002";
    //介于(0<= x <100)
    String ROLE_BETWEEN = "1003";

}
