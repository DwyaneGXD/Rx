package com.oasis.rx.core.tool;

import lombok.val;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public interface EncryptionTool
{
  /**
   * MD5加密
   */
  static String MD5(final String s)
  {
    try
    {
      val md5 = MessageDigest.getInstance("MD5");
      md5.update(StandardCharsets.UTF_8.encode(s));
      return String.format("%032x", new BigInteger(1, md5.digest()));
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * SHA1加密
   */
  static String SHA1(final String s)
  {
    try
    {
      val sha1 = MessageDigest.getInstance("SHA1");
      sha1.update(StandardCharsets.UTF_8.encode(s));
      return String.format("%032x", new BigInteger(1, sha1.digest()));
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Base64加密
   */
  static String base64Encode(final byte[] bytes)
  {
    return new String(Base64.getEncoder().encode(bytes));
  }

  /**
   * Base64解密
   * @param s
   * @return
   */
  static byte[] base64Decode(final String s)
  {
    return Base64.getDecoder().decode(s.getBytes());
  }

  /**
   * URL加密
   */
  static String urlEncode(final String s)
  {
    try
    {
      return URLEncoder.encode(s, "UTF-8");
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * URL解密
   */
  static String urlDecode(final String s)
  {
    try
    {
      return URLDecoder.decode(s, "UTF-8");
    }
    catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
      return null;
    }
  }
}
