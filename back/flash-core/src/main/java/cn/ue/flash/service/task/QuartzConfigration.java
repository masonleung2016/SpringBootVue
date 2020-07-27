package cn.ue.flash.service.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:24
 * @Package: cn.ue.flash.service.task
 * @Version 1.0
 */

@Configuration
public class QuartzConfigration {

  @Bean(name = "scheduler")
  public SchedulerFactoryBean schedulerFactory() {
    SchedulerFactoryBean bean = new SchedulerFactoryBean();
    return bean;
  }
}
