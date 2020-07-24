package cn.ue.flash.warpper;

import cn.ue.flash.bean.entity.system.Dict;
import cn.ue.flash.service.system.impl.ConstantFactory;
import cn.ue.flash.utils.ToolUtil;

import java.util.List;
import java.util.Map;

/**
 * @Description: 字典列表的包装
 * @Author: LCF
 * @Date: 2020/7/20 15:53
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        Long id = (Long) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if (dicts != null) {
            for (Dict dict : dicts) {
                detail.append(dict.getNum() + ":" + dict.getName() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(), ","));
        }
    }

}
