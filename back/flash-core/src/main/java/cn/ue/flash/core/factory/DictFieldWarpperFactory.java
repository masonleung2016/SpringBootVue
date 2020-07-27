package cn.ue.flash.core.factory;

import cn.ue.flash.bean.enumeration.BizExceptionEnum;
import cn.ue.flash.bean.exception.ApplicationException;
import cn.ue.flash.service.system.IConstantFactory;
import cn.ue.flash.service.system.impl.ConstantFactory;

import java.lang.reflect.Method;

/**
 * @Description: 字段的包装创建工厂
 * @Author: LCF
 * @Date: 2020/7/20 14:42
 * @Package: cn.ue.flash.core.factory
 * @Version 1.0
 */

public class DictFieldWarpperFactory {

  public static Object createFieldWarpper(Object field, String methodName) {
    IConstantFactory me = ConstantFactory.me();
    try {
      Method method = IConstantFactory.class.getMethod(methodName, field.getClass());
      Object result = method.invoke(me, field);
      return result;
    } catch (Exception e) {
      try {
        Method method = IConstantFactory.class.getMethod(methodName, Long.class);
        Object result = method.invoke(me, Long.valueOf(field.toString()));
        return result;
      } catch (Exception e1) {
        try {
          Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
          Object result = method.invoke(me, Integer.parseInt(field.toString()));
          return result;
        } catch (Exception e2) {
          throw new ApplicationException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
        }
      }
    }
  }

}
