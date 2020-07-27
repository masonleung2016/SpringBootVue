package cn.ue.flash.service.task;

import cn.ue.flash.bean.entity.system.Task;
import cn.ue.flash.bean.entity.system.TaskLog;
import cn.ue.flash.bean.vo.QuartzJob;
import cn.ue.flash.dao.system.TaskLogRepository;
import cn.ue.flash.dao.system.TaskRepository;
import cn.ue.flash.utils.StringUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:21
 * @Package: cn.ue.flash.service.task
 * @Version 1.0
 */

@Component
public abstract class AbstractJobExecuter {

  protected static final Logger log = LoggerFactory.getLogger(AbstractJobExecuter.class);

  @Autowired
  private TaskService taskService;

  @Autowired
  private TaskLogRepository taskLogRepository;
  @Autowired
  private TaskRepository taskRepository;

  private QuartzJob job;

  public static Logger getLog() {
    return log;
  }

  public void execute() {
    Map dataMap = job.getDataMap();
    String taskId = job.getJobName();
    Task task = taskService.get(Long.valueOf(taskId));
    final String taskName = (String) task.getName();
    log.info(">>>>>>>>>>>>>>>>>开始执行定时任务[" + taskName + "]...<<<<<<<<<<<<<<<<<<<");

    String exeResult = "执行成功";
    final TaskLog taskLog = new TaskLog();
    taskLog.setName(taskName);
    final Date exeAt = new Date();
    taskLog.setExecAt(exeAt);
    taskLog.setIdTask(task.getId());
    /**默认是成功 出异常后改成失败*/
    taskLog.setExecSuccess(TaskLog.EXE_SUCCESS_RESULT);
    try {
      execute(dataMap);
    } catch (Exception e) {
      log.error("exeucte " + getClass().getName() + " error : ", e);
      exeResult = "执行失败\n";
      exeResult += ExceptionUtils.getStackTrace(e);
      taskLog.setExecSuccess(TaskLog.EXE_FAILURE_RESULT);
      taskLog.setJobException(e.getClass().getName());
    }
    task.setExecResult(exeResult);
    task.setExecAt(exeAt);
    taskLogRepository.save(taskLog);
    taskRepository.save(task);
    log.info(">>>>>>>>>>>>>>>>>执行定时任务[" + taskName + "]结束<<<<<<<<<<<<<<<<<<<");
  }

  /**
   * 数据库配置的参数
   *
   * @param dataMap
   */
  public abstract void execute(Map<String, Object> dataMap) throws Exception;

  public String getEmail() {
    return getEmail("snowalert@xuezhongdai.cn");
  }

  public String getEmail(String defaultEmail) {
    Map<String, Object> dataMap = job.getDataMap();
    String toEmail = null;
    if (dataMap != null && dataMap.containsKey("email")) {
      toEmail = StringUtil.sNull(dataMap.get("email"));
    }
    if (StringUtil.isEmpty(toEmail)) {
      toEmail = defaultEmail;
    }
    return toEmail;
  }

  public TaskService getTaskService() {
    return taskService;
  }

  public void setTaskService(TaskService taskService) {
    this.taskService = taskService;
  }

  public TaskLogRepository getTaskLogRepository() {
    return taskLogRepository;
  }

  public void setTaskLogRepository(TaskLogRepository taskLogRepository) {
    this.taskLogRepository = taskLogRepository;
  }

  public TaskRepository getTaskRepository() {
    return taskRepository;
  }

  public void setTaskRepository(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public QuartzJob getJob() {
    return job;
  }

  public void setJob(QuartzJob job) {
    this.job = job;
  }
}
