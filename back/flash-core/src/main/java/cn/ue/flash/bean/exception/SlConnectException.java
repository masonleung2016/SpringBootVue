package cn.ue.flash.bean.exception;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:19
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class SlConnectException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorCode;
    private List<String> details;

    public SlConnectException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

}
