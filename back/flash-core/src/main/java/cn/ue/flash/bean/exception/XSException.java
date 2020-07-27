package cn.ue.flash.bean.exception;

/**
 * @Description: 定义通用异常。code 存储异常代码
 * @Author: LCF
 * @Date: 2020/7/20 14:20
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class XSException extends Exception {

  private static final long serialVersionUID = 1L;

  private String code;

  public XSException(String code, String message, Throwable t) {
    super(message, t);
    this.code = code;
  }

  public XSException(String code, String message) {
    this(code, message, null);
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
