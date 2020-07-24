package cn.ue.flash.warpper;

import cn.ue.flash.service.system.impl.ConstantFactory;
import cn.ue.flash.utils.Constants;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.StringUtil;

import java.util.Date;
import java.util.Map;

/**
 * @Description: 日志列表的包装类
 * @Author: LCF
 * @Date: 2020/7/20 15:53
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public class LogWarpper extends BaseControllerWarpper {

    public LogWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        String message = (String) map.get("message");

        Long userid = Long.valueOf(map.get("userid").toString());
        map.put("userName", ConstantFactory.me().getUserNameById(userid));

        /**如果信息过长,则只截取前100位字符串*/
        if (StringUtil.isNotEmpty(message) && message.length() >= 100) {
            String subMessage = message.substring(0, 100) + "...";
            map.put("message", subMessage);
        }
        map.put("createtime", DateUtil.format((Date) map.get("createTime"), "yyyy-MM-dd hh:MM:ss"));
        /**如果信息中包含分割符号;;;   则分割字符串返给前台*/
        if (StringUtil.isNotEmpty(message) && message.indexOf(Constants.SEPARATOR) != -1) {
            String[] msgs = message.split(Constants.SEPARATOR);
            map.put("regularMessage", msgs);
        } else {
            map.put("regularMessage", message);
        }
    }

}
