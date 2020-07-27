package cn.ue.flash.utils;

import java.util.Base64;

/**
 * @Description: 加密工具类
 * @Author: LCF
 * @Date: 2020/7/20 15:37
 * @Package: cn.ue.flash.utils
 * @Version 1.0
 */

public class CryptUtil {

  public static String encodebase64(byte[] bytes) {

    String encode = Base64.getEncoder().encodeToString(bytes);
    encode = encode.replaceAll("\n", "");
    return encode;
  }


}