package cn.ue.flash.bean.exception;

/**
 * @Description: 抽象接口
 * @Author: LCF
 * @Date: 2020/7/20 14:19
 * @Package: cn.ue.flash.bean.exception
 * @Version 1.0
 */

public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
