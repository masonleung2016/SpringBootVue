package cn.ue.flash.service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:29
 * @Package: cn.ue.flash.service
 * @Version 1.0
 */

public interface UpdateService<T, ID> {
  /**
   * 修改记录信息
   *
   * @param record 要修改的对象
   * @return 返回修改的记录
   */
  T update(T record);
}
