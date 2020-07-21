package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Contacts;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.service.cms.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:28
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@RestController
@RequestMapping("/offcialsite/contact")
public class ContactController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ContactsService contactsService;

    @RequestMapping(method = RequestMethod.POST)
    public Object save(@Valid Contacts contacts) {
        contactsService.insert(contacts);
        return Rets.success();
    }
}
