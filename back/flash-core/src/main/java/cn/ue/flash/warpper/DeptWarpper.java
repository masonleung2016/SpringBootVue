package cn.ue.flash.warpper;

import cn.ue.flash.service.system.impl.ConstantFactory;

import java.util.Map;

/**
 * @Description: 部门列表的包装
 * @Author: LCF
 * @Date: 2020/7/20 15:52
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class DeptWarpper extends BaseControllerWarpper {

  public DeptWarpper(Object list) {
    super(list);
  }

  @Override
  public void warpTheMap(Map<String, Object> map) {

    Long pid = (Long) map.get("pid");

    if (pid == null || pid.intValue() == 0) {
      map.put("pName", "--");
    } else {
      map.put("pName", ConstantFactory.me().getDeptName(pid));
    }
  }

}
