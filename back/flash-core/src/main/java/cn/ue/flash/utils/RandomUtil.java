package cn.ue.flash.utils;

import java.util.Random;

/**
 * @Description: 获取随机位数的字符串
 * @Author: LCF
 * @Date: 2020/7/20 15:46
 * @Package: cn.ue.flash.utils
 * @Version 1.0
 */

public class RandomUtil {
  public static String getRandomString(int length) {
    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; i++) {
      int number = random.nextInt(base.length());
      sb.append(base.charAt(number));
    }
    return sb.toString();
  }
}
