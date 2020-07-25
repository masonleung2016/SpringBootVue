package cn.ue.flash.api.runner;

import cn.ue.flash.bean.vo.QuartzJob;
import cn.ue.flash.service.task.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 启动定时任务
 * @Author: LCF
 * @Date: 2020/7/20 13:41
 * @Package: cn.ue.flash.api.runner
 * @Version 1.0
 */

@Component
public class StartJob implements ApplicationRunner {

    @Autowired
    private JobService jobService;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("start Job >>>>>>>>>>>>>>>>>>>>>>>");
        List<QuartzJob> list = jobService.getTaskList();
        for (QuartzJob quartzJob : list) {
            jobService.addJob(quartzJob);
        }
    }
}
