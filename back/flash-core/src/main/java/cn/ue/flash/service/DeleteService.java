package cn.ue.flash.service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:27
 * @Package: cn.ue.flash.service
 * @Version 1.0
 */

public interface DeleteService<ID> {

  /**
   * 根据主键删除记录
   *
   * @param id 主键
   */
  void delete(ID id);

  /**
   * 根据主键删除记录
   *
   * @param ids 主键集合
   */
  void delete(Iterable<ID> ids);

  /**
   * 清空表数据
   */
  void clear();
}
