package com.oasis.rx.product.tool.exception;

public class ApiException extends Exception {
    public final int code;
    public final String message;

    public ApiException(final int code, final String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
