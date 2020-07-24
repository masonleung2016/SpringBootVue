package cn.ue.flash.bean.enumeration;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:12
 * @Package: cn.ue.flash.bean.enumeration
 * @Version 1.0
 */

public enum MessageTemplateEnum {
    /**
     * 注册验证码
     */
    REGISTER_CODE("REGISTER_CODE", "注册验证码");
    private String code;
    private String name;

    MessageTemplateEnum(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
