package cn.ue.flash.bean.constant.state;

/**
 * @Description: 菜单的状态
 * @Author: LCF
 * @Date: 2020/7/20 13:50
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum MenuStatus {

  ENABLE(1, "启用"),
  DISABLE(0, "禁用");

  int code;
  String message;

  MenuStatus(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public static String valueOf(Integer status) {
    if (status == null) {
      return "";
    } else {
      for (MenuStatus s : MenuStatus.values()) {
        if (s.getCode() == status) {
          return s.getMessage();
        }
      }
      return "";
    }
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
