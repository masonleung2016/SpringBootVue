package cn.ue.flash.bean.exception;

/**
 * @Description: 异常枚举
 * @Author: LCF
 * @Date: 2020/7/20 14:17
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public enum ApplicationExceptionEnum implements ServiceExceptionEnum {

    /**
     * 其他
     */
    WRITE_ERROR(500, "渲染界面错误"),

    /**
     * 文件上传
     */
    FILE_READING_ERROR(400, "FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400, "FILE_NOT_FOUND!"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常"),

    TASK_CONFIG_ERROR(500, "定时任务配置错误");

    private Integer code;
    private String message;

    ApplicationExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
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
