package cn.ue.flash.code;

import org.nutz.lang.Strings;

/**
 * @Description: 工具类
 * @Author: LCF
 * @Date: 2020/7/20 16:05
 * @Package: cn.ue.flash.code
 * @Version 1.0
 */

public class Utils {
  /**
   * 将以“_”分割的单词转换为首字母小写驼峰格式
   *
   * @param src
   * @return
   */
  public static String lowerCamel(String src) {
    src = src.toLowerCase();
    StringBuilder result = new StringBuilder();
    for (String sitem : src.split("_")) {
      if (result.toString().length() == 0) {
        result.append(sitem);
      } else {
        result.append(Strings.upperFirst(sitem));
      }
    }
    return result.toString();
  }

  /**
   * 以“_”分割的单词转换为首字母大写驼峰格式
   *
   * @param src
   * @return
   */
  public static String upperCamel(String src) {
    if (!src.contains("_")) {
      return src;
    }
    src = src.toLowerCase();
    StringBuilder result = new StringBuilder();
    for (String sitem : src.split("_")) {
      if (result.toString().length() == 0) {
        result.append(Strings.upperFirst(sitem));
      } else {
        result.append(Strings.upperFirst(sitem));
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(upperCamel("AAAA_BBBB"));
  }
}
