package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.Cfg;
import cn.ue.flash.cache.ConfigCache;
import cn.ue.flash.dao.system.CfgRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:09
 * @Package: cn.ue.flash.service.system.impl
 * @Version 1.0
 */

@Service
@Transactional
public class CfgService extends BaseService<Cfg, Long, CfgRepository> {
    @Autowired
    private ConfigCache configCache;

    public Cfg saveOrUpdate(Cfg cfg) {
        if (cfg.getId() == null) {
            insert(cfg);
        } else {
            update(cfg);
        }
        configCache.cache();
        return cfg;
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
        configCache.cache();
    }

}
