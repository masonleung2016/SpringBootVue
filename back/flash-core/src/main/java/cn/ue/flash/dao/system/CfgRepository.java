package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Cfg;
import cn.ue.flash.dao.BaseRepository;

/**
 * @Description: 全局参数dao
 * @Author: LCF
 * @Date: 2020/7/20 14:50
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface CfgRepository extends BaseRepository<Cfg, Long> {

    Cfg findByCfgName(String cfgName);
}

