package cn.ue.flash.bean.vo.front;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:21
 * @Package: cn.ue.flash.bean.vo.front
 * @Version 1.0
 */

@Getter
@Setter
public class Ret<T> {

  private Integer code;
  private String msg;
  private T data;
  private boolean success;

  public Ret() {

  }

  public Ret(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    this.success = Rets.SUCCESS.intValue() == code.intValue();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("{");
    builder.append("'code':").append(code).append(",");
    builder.append("'msg':").append(msg).append(",");
    builder.append("'success':").append(success).append(",");
    builder.append("}");
    return builder.toString();
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
}
