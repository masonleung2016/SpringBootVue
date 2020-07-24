package cn.ue.flash.bean.enumeration;

/**
 * @Description: redis队列名称
 * @Author: LCF
 * @Date: 2020/7/20 14:14
 * @Package: cn.ue.flash.bean.enumeration
 * @Version 1.0
 */

public enum RedisQueueName {
    CREDIT_LIMIT("credit_limit"), COLLECTION_TAG("collection_tag");

    private String value;

    RedisQueueName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
