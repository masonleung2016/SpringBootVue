package cn.ue.flash.bean.exception;

/**
 * @Description: 封装系统的异常
 * @Author: LCF
 * @Date: 2020/7/20 14:17
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public class ApplicationException extends RuntimeException {

    private Integer code;

    private String message;

    public ApplicationException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
