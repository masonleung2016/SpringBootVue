package cn.ue.flash.bean.constant.state;

/**
 * @Description: 业务是否成功的日志记录
 * @Author: LCF
 * @Date: 2020/7/20 13:49
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum LogSucceed {

  SUCCESS("成功"),
  FAIL("失败");

  String message;

  LogSucceed(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}