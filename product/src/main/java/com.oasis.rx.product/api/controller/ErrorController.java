package com.oasis.rx.product.api.controller;

import com.oasis.rx.core.tool.Restful;
import com.oasis.rx.product.tool.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by SY on 2017/11/29.
 */
@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity badRequest(final ApiException e) {
        return Restful.badRequest(e.code, e.message);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity error() {
//        return new ResponseEntity<>(API.Map("code", 9999, "msg", "服务器错误，请联系管理员!"), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
