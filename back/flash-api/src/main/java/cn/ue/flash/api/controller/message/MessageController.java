package cn.ue.flash.api.controller.message;

import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.message.Message;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.message.MessageService;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:31
 * @Package: cn.ue.flash.api.controller.message
 * @Version 1.0
 */

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.MSG})
    public Object list(@RequestParam(required = false) String tplCode,
                       @RequestParam(required = false) String startDate,
                       @RequestParam(required = false) String endDate) {
        Page<Message> page = new PageFactory<Message>().defaultPage();
        page.addFilter("tplCode", tplCode);
        page.addFilter("createTime", SearchFilter.Operator.GTE, DateUtil.parse(startDate, "yyyyMMddHHmmss"));
        page.addFilter("createTime", SearchFilter.Operator.LTE, DateUtil.parse(endDate, "yyyyMMddHHmmss"));
        page = messageService.queryPage(page);
        page.setRecords(page.getRecords());
        return Rets.success(page);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "清空所有历史消息")
    @RequiresPermissions(value = {Permission.MSG_CLEAR})
    public Object clear() {
        messageService.clear();
        return Rets.success();
    }
}
