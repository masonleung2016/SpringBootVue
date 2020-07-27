package cn.ue.flash.security;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:01
 * @Package: cn.ue.flash.security
 * @Version 1.0
 */

public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException(String msg) {
    super(msg);
  }

  public UnauthorizedException() {
    super();
  }
}