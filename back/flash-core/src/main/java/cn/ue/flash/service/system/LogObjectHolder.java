package cn.ue.flash.service.system;

import cn.ue.flash.bean.vo.SpringContextHolder;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * @Description: 被修改的bean临时存放的地方
 * @Author: LCF
 * @Date: 2020/7/20 15:14
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable {

  private Object object = null;

  public static LogObjectHolder me() {
    LogObjectHolder bean = SpringContextHolder.getBean(LogObjectHolder.class);
    return bean;
  }

  public void set(Object obj) {
    try {
      /**为表面后面的逻辑对obj进行变更，这里克隆一份存储，用于后续变化对比*/
      Object cloneObj = BeanUtils.cloneBean(obj);
      this.object = cloneObj;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object get() {
    return object;
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }
}
