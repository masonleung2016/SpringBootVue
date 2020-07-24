package cn.ue.flash.bean.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 权限注解 用于检查权限 规定访问权限
 * @Author: LCF
 * @Date: 2020/7/20 13:54
 * @Package: cn.ue.flash.bean.core
 * @Version 1.0
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    String[] value() default {};
}
