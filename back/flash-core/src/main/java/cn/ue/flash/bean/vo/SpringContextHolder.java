package cn.ue.flash.bean.vo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: Spring的ApplicationContext的持有者, 可以用静态方法的方式获取spring容器中的bean
 * @Author: LCF
 * @Date: 2020/7/20 14:36
 * @Package: cn.ue.flash.bean.vo
 * @Version 1.0
 */

@Component
public class SpringContextHolder implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  public static ApplicationContext getApplicationContext() {
    assertApplicationContext();
    return applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextHolder.applicationContext = applicationContext;
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String beanName) {
    assertApplicationContext();
    return (T) applicationContext.getBean(beanName);
  }

  public static <T> T getBean(Class<T> requiredType) {
    assertApplicationContext();
    return applicationContext.getBean(requiredType);
  }

  private static void assertApplicationContext() {
    if (SpringContextHolder.applicationContext == null) {
      throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
    }
  }

}
