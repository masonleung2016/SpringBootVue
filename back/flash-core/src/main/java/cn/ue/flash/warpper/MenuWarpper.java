package cn.ue.flash.warpper;

import cn.ue.flash.bean.vo.node.IsMenu;
import cn.ue.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * @Description: 菜单列表的包装类
 * @Author: LCF
 * @Date: 2020/7/20 15:55
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class MenuWarpper extends BaseControllerWarpper {

    public MenuWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("statusName", ConstantFactory.me().getMenuStatusName((Integer) map.get("status")));
        map.put("isMenuName", IsMenu.valueOf((Integer) map.get("ismenu")));
    }

}
