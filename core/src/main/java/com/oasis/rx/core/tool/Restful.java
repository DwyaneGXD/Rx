package com.oasis.rx.core.tool;

import static io.vavr.API.Option;

import com.oasis.rx.core.constant.RequestField;
import io.vavr.API;
import io.vavr.collection.HashMap;
import io.vavr.control.Option;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public interface Restful {
  /**
   * 400错误信息
   */
  @AllArgsConstructor
  @ToString
  final class ApiError {
    public final int code;
    public final String msg;
  }

  static ResponseEntity ok() {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .build();
  }

  static <T> ResponseEntity ok(final String key, final T data) {
    return ok(API.Map(key, data));
  }

  static <T> ResponseEntity ok(final T data) {
    return ok(Option(data));
  }

  static <T> ResponseEntity ok(final Option<T> data) {
    return data.map(d -> ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(data))
        .getOrElse(Restful::notFound);
  }

  /**
   * 妥协让步,给body放置了个id.没办法唉 By Ryze
   */
  static ResponseEntity created(final HttpServletRequest request, final String id) {
    return ResponseEntity.created(URI.create(request.getRequestURL() + "/" + id))
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(API.Map(RequestField.DATA, id));
  }

  static ResponseEntity noContent() {
    return ResponseEntity.noContent().build();
  }

  static ResponseEntity badRequest() {
    return ResponseEntity.badRequest()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .build();
  }

  static <T> ResponseEntity badRequest(final T data) {
    return ResponseEntity.badRequest()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(data);
  }

  static ResponseEntity badRequest(final int code, final String msg) {
    return ResponseEntity.badRequest()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(HashMap.of("code", code, "msg", msg));
  }

  /**
   * 404资源不存在
   */
  static ResponseEntity notFound() {
    return ResponseEntity.notFound().build();
  }
}
