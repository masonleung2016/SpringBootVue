package cn.ue.flash.bean.constant.state;

/**
 * @Description: 日志类型
 * @Author: LCF
 * @Date: 2020/7/20 13:50
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum LogType {

    BUSSINESS("业务日志"),
    EXCEPTION("异常日志"),
    EXIT("退出日志"),
    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
