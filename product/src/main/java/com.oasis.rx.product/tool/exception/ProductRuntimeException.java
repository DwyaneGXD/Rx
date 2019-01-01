package com.oasis.rx.product.tool.exception;

import java.io.Serializable;

/**
 * @author 郭贤达
 * @Time 2017/9/28 0028
 */
public class ProductRuntimeException extends RuntimeException implements Serializable {
    public ProductRuntimeException() {
    }

    public ProductRuntimeException(String message) {
        super(message);
    }

    public ProductRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductRuntimeException(Throwable cause) {
        super(cause);
    }
}
