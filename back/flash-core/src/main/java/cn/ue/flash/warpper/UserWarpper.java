package cn.ue.flash.warpper;

import cn.ue.flash.service.system.impl.ConstantFactory;
import cn.ue.flash.utils.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @Description: 用户管理的包装类
 * @Author: LCF
 * @Date: 2020/7/20 15:56
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class UserWarpper extends BaseControllerWarpper {

  public UserWarpper(List<Map<String, Object>> list) {
    super(list);
  }

  @Override
  public void warpTheMap(Map<String, Object> map) {
    map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
    if (StringUtil.isNotNullOrEmpty(map.get("roleid"))) {
      map.put("roleName", ConstantFactory.me().getRoleName((String) map.get("roleid")));
    }
    map.put("statusName", ConstantFactory.me().getStatusName((Integer) map.get("status")));

  }

}