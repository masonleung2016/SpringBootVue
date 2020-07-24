package cn.ue.flash.bean.exception;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:21
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

@SuppressWarnings("serial")
public class XSRuntimeException extends RuntimeException {

    public XSRuntimeException(String msg) {
        super(msg);
    }

    public XSRuntimeException(String msg, Throwable e) {
        super(msg, e);
    }
}
