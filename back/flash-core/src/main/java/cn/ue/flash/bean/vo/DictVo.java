package cn.ue.flash.bean.vo;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:35
 * @Package: cn.ue.flash.bean.vo
 * @Version 1.0
 */

public class DictVo {
    private String key;
    private String value;

    public DictVo() {
    }

    public DictVo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public DictVo(Object num, Object name) {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
