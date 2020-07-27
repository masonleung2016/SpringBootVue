package cn.ue.flash.bean.exception;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:18
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class MailException extends Exception {

  public MailException(String msg) {
    super(msg);
  }

  public MailException(String msg, Throwable e) {
    super(msg, e);
  }
}
