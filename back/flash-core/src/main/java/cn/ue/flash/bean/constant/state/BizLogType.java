package cn.ue.flash.bean.constant.state;

/**
 * @Description: 业务日志类型
 * @Author: LCF
 * @Date: 2020/7/20 13:49
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum BizLogType {

  ALL(0, null),
  /**
   * 全部日志
   */
  BUSSINESS(1, "业务日志"),
  EXCEPTION(2, "异常日志");

  Integer val;
  String message;

  BizLogType(Integer val, String message) {
    this.val = val;
    this.message = message;
  }

  public static String valueOf(Integer value) {
    if (value == null) {
      return null;
    } else {
      for (BizLogType bizLogType : BizLogType.values()) {
        if (bizLogType.getVal().equals(value)) {
          return bizLogType.getMessage();
        }
      }
      return null;
    }
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(Integer val) {
    this.val = val;
  }
}
