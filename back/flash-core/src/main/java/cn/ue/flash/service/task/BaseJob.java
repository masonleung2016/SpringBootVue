package cn.ue.flash.service.task;

import cn.ue.flash.bean.vo.QuartzJob;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:20
 * @Package: cn.ue.flash.service.task.job
 * @Version 1.0
 */

@Component
public class BaseJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getJobDetail().getJobDataMap();
        QuartzJob job = (QuartzJob) data.get("job");
        try {
            TaskUtils.executeJob(job);
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
