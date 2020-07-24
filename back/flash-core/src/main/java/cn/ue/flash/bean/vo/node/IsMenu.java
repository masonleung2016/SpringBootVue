package cn.ue.flash.bean.vo.node;

/**
 * @Description: 是否菜单的枚举
 * @Author: LCF
 * @Date: 2020/7/20 14:23
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

public enum IsMenu {

    YES(1, "是"),
    NO(0, "不是");
    /**不是菜单的是按钮*/

    int code;
    String message;

    IsMenu(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (IsMenu s : IsMenu.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
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
