package cn.ue.flash.api.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 对Session的管理
 * @Author: LCF
 * @Date: 2020/7/20 13:43
 * @Package: cn.ue.flash.api.utils
 * @Version 1.0
 */

public class SessionUtils {

  public static HttpSession getSession() {
    if (RequestContextHolder.getRequestAttributes() == null) {
      return null;
    }
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    return request.getSession();
  }

  public static HttpServletRequest getRequest() {
    if (RequestContextHolder.getRequestAttributes() == null) {
      return null;
    }
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    return request;
  }

  public static ServletContext getServletContext() {
    WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
    return context.getServletContext();
  }
}