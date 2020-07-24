package cn.ue.flash.warpper;

import cn.ue.flash.service.system.impl.ConstantFactory;

import java.util.Map;

/**
 * @Description: 部门列表的包装
 * @Author: LCF
 * @Date: 2020/7/20 15:55
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Long creater = (Long) map.get("createBy");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
