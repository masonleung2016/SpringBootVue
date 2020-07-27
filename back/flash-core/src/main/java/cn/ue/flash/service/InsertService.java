package cn.ue.flash.service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:28
 * @Package: cn.ue.flash.service
 * @Version 1.0
 */

public interface InsertService<T, ID> {

  /**
   * 添加一条数据
   *
   * @param record 要添加的数据
   * @return 添加后生成的主键
   */
  T insert(T record);
}