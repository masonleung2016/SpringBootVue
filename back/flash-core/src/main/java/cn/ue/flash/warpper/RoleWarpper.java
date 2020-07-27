package cn.ue.flash.warpper;

import cn.ue.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * @Description: 角色列表的包装类
 * @Author: LCF
 * @Date: 2020/7/20 15:56
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class RoleWarpper extends BaseControllerWarpper {

  public RoleWarpper(List<Map<String, Object>> list) {
    super(list);
  }

  @Override
  public void warpTheMap(Map<String, Object> map) {
    map.put("pName", ConstantFactory.me().getSingleRoleName((Long) map.get("pid")));
    map.put("deptName", ConstantFactory.me().getDeptName((Long) map.get("deptid")));
  }

}
