package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.*;
import cn.ue.flash.bean.vo.DictVo;
import cn.ue.flash.bean.entity.system.*;

import java.util.List;

/**
 * @Description: 常量生产工厂的接口
 * @Author: LCF
 * @Date: 2020/7/20 15:13
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

public interface IConstantFactory {

  /**
   * 根据用户id获取用户名称
   */
  String getUserNameById(Long userId);

  /**
   * 根据用户id获取用户账号
   */
  String getUserAccountById(Long userId);

  /**
   * 通过角色ids获取角色名称
   */
  String getRoleName(String roleIds);

  /**
   * 通过角色id获取角色名称
   */
  String getSingleRoleName(Long roleId);

  /**
   * 通过角色id获取角色英文名称
   */
  String getSingleRoleTip(Long roleId);

  /**
   * 获取部门名称
   */
  String getDeptName(Long deptId);

  /**
   * 获取菜单的名称们(多个)
   */
  String getMenuNames(String menuIds);

  /**
   * 获取菜单名称
   */
  String getMenuName(Long menuId);

  /**
   * 获取菜单名称通过编号
   */
  String getMenuNameByCode(String code);

  /**
   * 根据字典名称获取字典列表
   *
   * @param dictName
   * @return
   */
  List<DictVo> findByDictName(String dictName);

  /**
   * 获取字典名称
   */
  String getDictName(Long dictId);

  /**
   * 获取通知标题
   */
  String getNoticeTitle(Long dictId);

  /**
   * 根据字典名称和字典中的值获取对应的名称
   */
  String getDictsByName(String name, String val);

  /**
   * 获取性别名称
   */
  String getSexName(Integer sex);

  /**
   * 获取银行卡类型名称
   *
   * @param cardType
   * @return
   */
  String getCardTypeName(String cardType);

  /**
   * 获取个人证件类型
   *
   * @param cardType
   * @return
   */
  String getIdCardTypeName(String cardType);

  /**
   * 获取联系人关系
   *
   * @param relation
   * @return
   */
  String getRelationName(String relation);

  /**
   * 获取用户登录状态
   */
  String getStatusName(Integer status);

  /**
   * 获取菜单状态
   */
  String getMenuStatusName(Integer status);

  /**
   * 查询字典
   */
  List<Dict> findInDict(Long id);

  /**
   * 获取被缓存的对象(用户删除业务)
   */
  String getCacheObject(String para);

  /**
   * 获取子部门id
   */
  List<Long> getSubDeptId(Long deptid);

  /**
   * 获取所有父部门id
   */
  List<Integer> getParentDeptIds(Long deptid);


  /**
   * 获取指定名称下的字典列表
   *
   * @param pname
   * @return
   */
  List<Dict> getDicts(String pname);

  /**
   * 获取全局参数
   *
   * @param cfgName
   * @return
   */
  String getCfg(String cfgName);


  Role getRole(Long id);

  Dept getDept(Long id);

  Menu getMenu(Long id);

  Notice getNotice(Long id);

  void cleanLocalCache();
}
