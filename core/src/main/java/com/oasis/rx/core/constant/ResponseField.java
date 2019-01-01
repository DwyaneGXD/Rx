package com.oasis.rx.core.constant;

/**
 * 用于返回状态码
 */
public interface ResponseField {
    //已存在code
    String EXISTED_CODE="0011";
    //失败code
    String FAILED_CODE="1111";
    //已存在消息
    String EXISTED_MESSAGE="已存在";
    //失败消息
    String FAILED_MESSAGE="失败了";
    //同一来源code
    String SAME_CODE="0022";
    //同一来源消息
    String SAME_MESSAGE="同一来源只能添加一种商品";

    /*
    service层返controller层标识
     */
    //返回失败
    int RETURN_FAILED = 11;
    //返回已存在
    int RETURN_EXISTED = 22;
    //返回成功
    int RETURN_SUCCESSED = 33;
}
