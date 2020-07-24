package cn.ue.flash.service.task;

import cn.ue.flash.bean.vo.QuartzJob;
import cn.ue.flash.bean.vo.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:25
 * @Package: cn.ue.flash.service.task
 * @Version 1.0
 */

public class TaskUtils {

    private static final Logger logger = LoggerFactory.getLogger(TaskUtils.class);

    /**
     * 通过反射调用job中定义的方法
     * @param job
     * @throws Exception
     */
    public static void executeJob(QuartzJob job) throws Exception {
        AbstractJobExecuter AbstractJobExecuter = null;
        Class<?> clazz = null;
        if (StringUtils.isNotBlank(job.getJobClass())) {
            clazz = Class.forName(job.getJobClass());
            AbstractJobExecuter = (AbstractJobExecuter) SpringContextHolder.getBean(clazz);
            AbstractJobExecuter.setJob(job);
        }
        if (AbstractJobExecuter == null) {
            throw new RuntimeException("任务名称 = [" + job.getDescription() + "]未启动成功，请检查执行类是否配置正确！！！");
        }
        AbstractJobExecuter.execute();
    }

    /**
     * 判断cron时间表达式正确性
     * @param cronExpression
     * @return
     */
    public static boolean isValidExpression(final String cronExpression) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidExpression("0 0/1 * * * ?"));
    }
}
