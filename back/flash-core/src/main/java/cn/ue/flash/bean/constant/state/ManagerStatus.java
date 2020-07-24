package cn.ue.flash.bean.constant.state;

/**
 * @Description: 管理员的状态
 * @Author: LCF
 * @Date: 2020/7/20 13:50
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum ManagerStatus {

    DELETED(3, "被删除"), FREEZED(2, "冻结"), OK(1, "启用");

    int code;
    String message;

    ManagerStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (ManagerStatus ms : ManagerStatus.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
