package cn.ue.flash.bean.vo.front;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:22
 * @Package: cn.ue.flash.bean.vo.front
 * @Version 1.0
 */

public class Rets {

  public static final Integer SUCCESS = 20000;
  public static final Integer FAILURE = 9999;
  public static final Integer TOKEN_EXPIRE = 50014;

  public static Ret success(Object data) {
    return new Ret(Rets.SUCCESS, "成功", data);
  }

  public static Ret failure(String msg) {
    return new Ret(Rets.FAILURE, msg, null);
  }

  public static Ret success() {
    return new Ret(Rets.SUCCESS, "成功", null);
  }

  public static Ret expire() {
    return new Ret(Rets.TOKEN_EXPIRE, "token 过期", null);
  }

  public static Integer getSUCCESS() {
    return SUCCESS;
  }

  public static Integer getFAILURE() {
    return FAILURE;
  }

  public static Integer getTokenExpire() {
    return TOKEN_EXPIRE;
  }
}