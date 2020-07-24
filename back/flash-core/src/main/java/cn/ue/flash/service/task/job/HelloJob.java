package cn.ue.flash.service.task.job;

import cn.ue.flash.bean.entity.system.Cfg;
import cn.ue.flash.service.system.CfgService;
import cn.ue.flash.service.task.AbstractJobExecuter;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:20
 * @Package: cn.ue.flash.service.task.job
 * @Version 1.0
 */

@Component
public class HelloJob extends AbstractJobExecuter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CfgService cfgService;

    @Override
    public void execute(Map<String, Object> dataMap) throws Exception {
        Cfg cfg = cfgService.get(1L);
        cfg.setCfgDesc("update by " + DateUtil.getTime());
        cfgService.update(cfg);
        logger.info("hello :" + JsonUtil.toJson(dataMap));
    }
}
