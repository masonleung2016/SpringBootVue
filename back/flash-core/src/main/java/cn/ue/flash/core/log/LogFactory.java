package cn.ue.flash.core.log;

import cn.ue.flash.bean.constant.state.LogSucceed;
import cn.ue.flash.bean.constant.state.LogType;
import cn.ue.flash.bean.entity.system.LoginLog;
import cn.ue.flash.bean.entity.system.OperationLog;

import java.util.Date;

/**
 * @Description: 日志对象创建工厂
 * @Author: LCF
 * @Date: 2020/7/20 14:45
 * @Package: cn.ue.flash.core.log
 * @Version 1.0
 */

public class LogFactory {

  /**
   * 创建操作日志
   */
  public static OperationLog createOperationLog(LogType logType, Long userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
    OperationLog operationLog = new OperationLog();
    operationLog.setLogtype(logType.getMessage());
    operationLog.setLogname(bussinessName);
    operationLog.setUserid(userId.intValue());
    operationLog.setClassname(clazzName);
    operationLog.setMethod(methodName);
    operationLog.setCreateTime(new Date());
    operationLog.setSucceed(succeed.getMessage());
    operationLog.setMessage(msg);
    return operationLog;
  }

  /**
   * 创建登录日志
   */
  public static LoginLog createLoginLog(LogType logType, Long userId, String msg, String ip) {
    LoginLog loginLog = new LoginLog();
    loginLog.setLogname(logType.getMessage());
    loginLog.setUserid(userId.intValue());
    loginLog.setCreateTime(new Date());
    loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
    loginLog.setIp(ip);
    loginLog.setMessage(msg);
    return loginLog;
  }
}
