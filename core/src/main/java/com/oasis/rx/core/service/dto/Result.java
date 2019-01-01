package com.oasis.rx.core.service.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result
{
  public final int    code;
  public final String msg;
  public final Object data;
}
