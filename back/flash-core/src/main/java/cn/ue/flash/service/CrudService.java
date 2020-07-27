package cn.ue.flash.service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:27
 * @Package: cn.ue.flash.service
 * @Version 1.0
 */

public interface CrudService<T, ID> extends
    InsertService<T, ID>,
    UpdateService<T, ID>,
    DeleteService<ID>,
    SelectService<T, ID> {
}
