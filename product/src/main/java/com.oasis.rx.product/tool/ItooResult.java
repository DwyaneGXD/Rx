package com.oasis.rx.product.tool;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author 郭贤达
 * @version V1.0
 * @Description: 返回对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItooResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结果状态码
     */
    private String code;
    /**
     * 响应结果描述
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public ItooResult() {
        super();
    }

    /**
     * @param code 结果状态码
     * @param msg  响应结果描述
     */
    public ItooResult(String code, String msg) {
        super();
        this.code = code;
        this.message = msg;
    }

    /**
     * @param code 结果状态码
     * @param msg  响应结果描述
     * @param data 数据
     */
    public ItooResult(String code, String msg, Object data) {
        super();
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static ItooResult build(String code, String msg, Object data) {
        return new ItooResult(code, msg, data);
    }

    public static ItooResult build(String code, String msg) {
        return new ItooResult(code, msg, null);
    }


    /**
     * 结果状态码
     */
    public String getCode() {
        return code;
    }

    /**
     * 结果状态码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 响应结果描述
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置响应结果描述
     *
     * @param msg 响应结果描述
     */
    public void setMessage(String msg) {
        this.message = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
