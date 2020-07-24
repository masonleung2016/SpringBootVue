package cn.ue.flash.cache;

import cn.ue.flash.bean.vo.SpringContextHolder;
import cn.ue.flash.service.system.impl.ConstantFactory;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:39
 * @Package: cn.ue.flash.cache.impl
 * @Version 1.0
 */

public abstract class BaseCache implements Cache {
    @Override
    public void cache() {
        SpringContextHolder.getBean(ConstantFactory.class).cleanLocalCache();
    }
}
