package cn.ue.flash.api.controller.cms;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.entity.cms.Contacts;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.cms.ContactsService;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 邀约信息管理
 * @Author: LCF
 * @Date: 2020/7/20 13:26
 * @Package: cn.ue.flash.api.controller.cms
 * @Version 1.0
 */

@RestController
@RequestMapping("/contacts")
public class ContactsController extends BaseController {
  @Autowired
  private ContactsService contactsService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.CONTACTS})
  public Object list(@RequestParam(required = false) String userName,
                     @RequestParam(required = false) String mobile,
                     @RequestParam(required = false) String startDate,
                     @RequestParam(required = false) String endDate

  ) {
    Page<Contacts> page = new PageFactory<Contacts>().defaultPage();
    page.addFilter("createTime", SearchFilter.Operator.GTE, DateUtil.parse(startDate, "yyyyMMddHHmmss"));
    page.addFilter("createTime", SearchFilter.Operator.LTE, DateUtil.parse(endDate, "yyyyMMddHHmmss"));
    page.addFilter("userName", SearchFilter.Operator.EQ, userName);
    page.addFilter("mobile", SearchFilter.Operator.EQ, mobile);
    page = contactsService.queryPage(page);
    return Rets.success(page);
  }
}
