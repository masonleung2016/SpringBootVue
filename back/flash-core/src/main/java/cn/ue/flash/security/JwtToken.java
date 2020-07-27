package cn.ue.flash.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:58
 * @Package: cn.ue.flash.security
 * @Version 1.0
 */

public class JwtToken implements AuthenticationToken {

  /**
   * 密钥
   */
  private String token;

  public JwtToken(String token) {
    this.token = token;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}