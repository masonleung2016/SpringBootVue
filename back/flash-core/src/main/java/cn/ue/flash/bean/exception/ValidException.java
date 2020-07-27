package cn.ue.flash.bean.exception;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:20
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class ValidException extends RuntimeException {

  public ValidException(String msg) {
    super(msg);
  }

  public ValidException(String msg, Throwable e) {
    super(msg, e);
  }
}
