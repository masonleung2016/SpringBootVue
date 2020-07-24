package cn.ue.flash.cache.impl;

import cn.ue.flash.bean.entity.system.Cfg;
import cn.ue.flash.bean.enumeration.ConfigKeyEnum;
import cn.ue.flash.cache.BaseCache;
import cn.ue.flash.cache.CacheDao;
import cn.ue.flash.cache.ConfigCache;
import cn.ue.flash.dao.system.CfgRepository;
import cn.ue.flash.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 全局参数缓存实现类
 * @Author: LCF
 * @Date: 2020/7/20 14:37
 * @Package: cn.ue.flash.cache.impl
 * @Version 1.0
 */

@Service
public class ConfigCacheImpl extends BaseCache implements ConfigCache {
    private static final Logger logger = LoggerFactory.getLogger(ConfigCacheImpl.class);
    @Autowired
    private CfgRepository cfgRepository;
    @Autowired
    private CacheDao cacheDao;

    @Override
    public Object get(String key) {
        return cacheDao.hget(CacheDao.CONSTANT, key);
    }

    @Override
    public String get(String key, boolean local) {
        String ret = null;
        if (local) {
            ret = (String) get(key);
        } else {
            ret = (String) cfgRepository.findByCfgName(key).getCfgValue();
            set(key, ret);
        }
        return ret;
    }

    @Override
    public String get(String key, String def) {
        String ret = (String) get(key);
        if (StringUtil.isEmpty(ret)) {
            return ret;
        }
        return ret;
    }

    @Override
    public String get(ConfigKeyEnum configKeyEnum) {
        return get(configKeyEnum.getValue(), null);
    }


    @Override
    public void set(String key, Object val) {
        cacheDao.hset(CacheDao.CONSTANT, key, val);
    }

    @Override
    public void del(String key, String val) {
        cacheDao.hdel(CacheDao.CONSTANT, val);
    }

    @Override
    public void cache() {
        super.cache();
        List<Cfg> list = cfgRepository.findAll();
        if (list != null && !list.isEmpty()) {
            for (Cfg cfg : list) {
                if (StringUtil.isNotEmpty((String) cfg.getCfgName()) && StringUtil.isNotEmpty((String) cfg.getCfgValue())) {
                    set((String) cfg.getCfgName(), cfg.getCfgValue());
                }
            }
        }
    }
}
