package cn.ue.flash.core.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 日志管理器
 * @Author: LCF
 * @Date: 2020/7/20 14:45
 * @Package: cn.ue.flash.core.log
 * @Version 1.0
 */

public class LogManager {

  public static LogManager logManager = new LogManager();
  /**
   * 日志记录操作延时
   */
  private final int OPERATE_DELAY_TIME = 10;
  /**
   * 异步操作记录日志的线程池
   */
  private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

  private LogManager() {
  }

  public static LogManager me() {
    return logManager;
  }

  public static LogManager getLogManager() {
    return logManager;
  }

  public static void setLogManager(LogManager logManager) {
    LogManager.logManager = logManager;
  }

  public void executeLog(TimerTask task) {
    executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
  }

  public int getOPERATE_DELAY_TIME() {
    return OPERATE_DELAY_TIME;
  }

  public ScheduledThreadPoolExecutor getExecutor() {
    return executor;
  }

  public void setExecutor(ScheduledThreadPoolExecutor executor) {
    this.executor = executor;
  }
}
