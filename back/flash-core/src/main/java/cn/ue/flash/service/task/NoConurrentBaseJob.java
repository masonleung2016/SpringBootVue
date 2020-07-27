package cn.ue.flash.service.task;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:23
 * @Package: cn.ue.flash.service.task
 * @Version 1.0
 */

@Component
@DisallowConcurrentExecution
public class NoConurrentBaseJob extends BaseJob {
}
