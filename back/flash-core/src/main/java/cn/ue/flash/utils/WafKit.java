package cn.ue.flash.utils;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @Description: Web防火墙工具类
 * @Author: LCF
 * @Date: 2020/7/20 15:48
 * @Package: cn.ue.flash.utils
 * @Version 1.0
 */

public class WafKit {

  /**
   * @param value 待处理内容
   * @return
   * @Description 过滤XSS脚本内容
   */
  public static String stripXSS(String value) {
    String rlt = null;

    if (null != value) {
      /**
       * NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
       * avoid encoded attacks.
       * value = ESAPI.encoder().canonicalize(value);
       */


      /** Avoid null characters */
      rlt = value.replaceAll("", "");

      /** Avoid anything between script tags */
      Pattern scriptPattern = compile("<script>(.*?)</script>", CASE_INSENSITIVE);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Remove any lonesome </script> tag */
      scriptPattern = compile("</script>", CASE_INSENSITIVE);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /**  Remove any lonesome <script ...> tag */
      scriptPattern = compile("<script(.*?)>", CASE_INSENSITIVE
          | MULTILINE | DOTALL);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Avoid eval(...) expressions */
      scriptPattern = compile("eval\\((.*?)\\)", CASE_INSENSITIVE
          | MULTILINE | DOTALL);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Avoid expression(...) expressions */
      scriptPattern = compile("expression\\((.*?)\\)", CASE_INSENSITIVE
          | MULTILINE | DOTALL);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Avoid javascript:... expressions */
      scriptPattern = compile("javascript:", CASE_INSENSITIVE);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Avoid vbscript:... expressions */
      scriptPattern = compile("vbscript:", CASE_INSENSITIVE);
      rlt = scriptPattern.matcher(rlt).replaceAll("");

      /** Avoid onload= expressions */
      scriptPattern = compile("onload(.*?)=", CASE_INSENSITIVE
          | MULTILINE | DOTALL);
      rlt = scriptPattern.matcher(rlt).replaceAll("");
    }

    return rlt;
  }

  /**
   * @param value 待处理内容
   * @return
   * @Description 过滤SQL注入内容
   */
  public static String stripSqlInjection(String value) {
    return (null == value) ? null : value.replaceAll("('.+--)|(--)|(%7C)", "");
    /** value.replaceAll("('.+--)|(--)|(\\|)|(%7C)", ""); */
  }

  /**
   * @param value 待处理内容
   * @return
   * @Description 过滤SQL/XSS注入内容
   */
  public static String stripSqlXSS(String value) {
    return stripXSS(stripSqlInjection(value));
  }

}
