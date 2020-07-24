package cn.ue.flash.bean.exception;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:18
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class ParamException extends Exception {

    public ParamException(String msg) {
        super(msg);
    }

    public ParamException(String msg, Throwable e) {
        super(msg, e);
    }
}
