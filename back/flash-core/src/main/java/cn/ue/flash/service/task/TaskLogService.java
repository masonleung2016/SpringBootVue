package cn.ue.flash.service.task;

import cn.ue.flash.bean.entity.system.TaskLog;
import cn.ue.flash.dao.system.TaskLogRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Description: 定时任务日志服务类
 * @Author: LCF
 * @Date: 2020/7/20 15:24
 * @Package: cn.ue.flash.service.task
 * @Version 1.0
 */

@Service
public class TaskLogService extends BaseService<TaskLog, Long, TaskLogRepository> {
}
