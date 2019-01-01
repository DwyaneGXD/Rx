package com.oasis.rx.core.tool;

import io.vavr.collection.Stream;
import lombok.val;

import java.util.Random;

public interface StringTool
{
  /**
   * 产生指定位数随机字符串
   * @return
   */
  static String random(final int length)
  {
    val r = new Random();

    return Stream
             .iterate(String.valueOf(r.nextInt(10)), s ->
             {
               // 输出字母还是数字
               val output = r.nextInt(2) % 2 == 0 ? "char" : "int";
               // 小写
               val small = 97;
               return "char".equals(output) ? String.valueOf((char) (r.nextInt(26) + small))
                        : String.valueOf(r.nextInt(10));
             })
             .take(length)
             .reduce((x, y) -> x + y);
  }
}
