package cn.ue.flash.bean.core;

import java.lang.annotation.*;

/**
 * @Description: 标记需要做业务日志的方法
 * @Author: LCF
 * @Date: 2020/7/20 13:53
 * @Package: cn.ue.flash.bean.core
 * @Version 1.0
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {

    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "id";
}
