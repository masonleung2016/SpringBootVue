package cn.ue.flash.core.log;

import cn.ue.flash.bean.constant.state.LogSucceed;
import cn.ue.flash.bean.constant.state.LogType;
import cn.ue.flash.bean.entity.system.LoginLog;
import cn.ue.flash.bean.entity.system.OperationLog;
import cn.ue.flash.bean.vo.SpringContextHolder;
import cn.ue.flash.dao.system.LoginLogRepository;
import cn.ue.flash.dao.system.OperationLogRepository;
import cn.ue.flash.utils.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @Description: 日志操作任务创建工厂
 * @Author: LCF
 * @Date: 2020/7/20 14:46
 * @Package: cn.ue.flash.core.log
 * @Version 1.0
 */

public class LogTaskFactory {

  private static Logger logger = LoggerFactory.getLogger(LogManager.class);
  private static LoginLogRepository loginLogRepository = SpringContextHolder.getBean(LoginLogRepository.class);
  private static OperationLogRepository operationLogRepository = SpringContextHolder.getBean(OperationLogRepository.class);

  public static TimerTask loginLog(final Long userId, final String ip) {
    return new TimerTask() {
      @Override
      public void run() {
        try {
          LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
          loginLogRepository.save(loginLog);
        } catch (Exception e) {
          logger.error("创建登录日志异常!", e);
        }
      }
    };
  }

  public static TimerTask loginLog(final String username, final String msg, final String ip) {
    return new TimerTask() {
      @Override
      public void run() {
        LoginLog loginLog = LogFactory.createLoginLog(
            LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
        try {
          loginLogRepository.save(loginLog);
        } catch (Exception e) {
          logger.error("创建登录失败异常!", e);
        }
      }
    };
  }

  public static TimerTask exitLog(final Long userId, final String ip) {
    return new TimerTask() {
      @Override
      public void run() {
        LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, ip);
        try {
          loginLogRepository.save(loginLog);
        } catch (Exception e) {
          logger.error("创建退出日志异常!", e);
        }
      }
    };
  }

  public static TimerTask bussinessLog(final Long userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
    return new TimerTask() {
      @Override
      public void run() {
        OperationLog operationLog = LogFactory.createOperationLog(
            LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
        try {
          operationLogRepository.save(operationLog);
        } catch (Exception e) {
          logger.error("创建业务日志异常!", e);
        }
      }
    };
  }

  public static TimerTask exceptionLog(final Long userId, final Exception exception) {
    return new TimerTask() {
      @Override
      public void run() {
        String msg = ToolUtil.getExceptionMsg(exception);
        OperationLog operationLog = LogFactory.createOperationLog(
            LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
        try {
          operationLogRepository.save(operationLog);
        } catch (Exception e) {
          logger.error("创建异常日志异常!", e);
        }
      }
    };
  }

  public static Logger getLogger() {
    return logger;
  }

  public static void setLogger(Logger logger) {
    LogTaskFactory.logger = logger;
  }

  public static LoginLogRepository getLoginLogRepository() {
    return loginLogRepository;
  }

  public static void setLoginLogRepository(LoginLogRepository loginLogRepository) {
    LogTaskFactory.loginLogRepository = loginLogRepository;
  }

  public static OperationLogRepository getOperationLogRepository() {
    return operationLogRepository;
  }

  public static void setOperationLogRepository(OperationLogRepository operationLogRepository) {
    LogTaskFactory.operationLogRepository = operationLogRepository;
  }
}