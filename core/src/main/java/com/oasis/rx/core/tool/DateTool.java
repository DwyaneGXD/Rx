package com.oasis.rx.core.tool;

import lombok.val;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;
import java.util.Optional;

public interface DateTool
{
  String SECONDS    = "seconds";
  String MINUTES    = "minutes";
  String HOURS      = "hours";
  String DAYS       = "days";
  String FULLDATE   = "yyyy-MM-dd HH:mm:ss";
  String CHINA      = "yyyy年MM月dd日 HH时mm分ss秒";
  String TIMESTAMP  = "yyyyMMddHHmmss";
  String RFC822DATE = "EEE, dd MMM yyyy HH:mm:ss z";

  static Date toDate(final String date, final String pattern)
  {
    return Optional.of(date)
             .map(s -> DateTime.parse(s, DateTimeFormat.forPattern(pattern)).toDate())
             .orElse(null);
  }

  static String toString(final Date date, final String pattern)
  {
    val d = new DateTime(date, DateTimeZone.forID("Asia/Shanghai"));
    return d.toString(pattern);
  }

  /**
   * 时间戳
   */
  static long timeStamp()
  {
    return System.currentTimeMillis() / 1000;
  }

  static Date now()
  {
    return new Date();
  }
}
