package cn.ue.flash.core.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:44
 * @Package: cn.ue.flash.core.listener
 * @Version 1.0
 */

public class ConfigListener implements ServletContextListener {

  private static Map<String, String> conf = new HashMap<>();

  public static Map<String, String> getConf() {
    return conf;
  }

  public static void setConf(Map<String, String> conf) {
    ConfigListener.conf = conf;
  }

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    conf.clear();
  }

  @Override
  public void contextInitialized(ServletContextEvent evt) {
    ServletContext sc = evt.getServletContext();
    /** 项目路径*/
    conf.put("realPath", sc.getRealPath("/").replaceFirst("/", ""));
    conf.put("contextPath", sc.getContextPath());
  }
}
