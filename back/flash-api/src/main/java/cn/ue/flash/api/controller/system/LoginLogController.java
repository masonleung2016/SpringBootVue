package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.system.LoginLog;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.system.LoginLogService;
import cn.ue.flash.utils.BeanUtil;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.factory.Page;
import cn.ue.flash.warpper.LogWarpper;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 登录日志controller
 * @Author: LCF
 * @Date: 2020/7/20 13:34
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {
  @Autowired
  private LoginLogService loginlogService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.LOGIN_LOG})
  public Object list(@RequestParam(required = false) String beginTime,
                     @RequestParam(required = false) String endTime,
                     @RequestParam(required = false) String logName) {
    Page<LoginLog> page = new PageFactory<LoginLog>().defaultPage();
    page.addFilter("createTime", SearchFilter.Operator.GTE, DateUtil.parseDate(beginTime));
    page.addFilter("createTime", SearchFilter.Operator.LTE, DateUtil.parseDate(endTime));
    page.addFilter("logname", SearchFilter.Operator.LIKE, logName);
    Page pageResult = loginlogService.queryPage(page);
    pageResult.setRecords((List<LoginLog>) new LogWarpper(BeanUtil.objectsToMaps(pageResult.getRecords())).warp());
    return Rets.success(pageResult);

  }

  /**
   * 清空日志
   */
  @RequestMapping(method = RequestMethod.DELETE)
  @BussinessLog(value = "清空登录日志")
  @RequiresPermissions(value = {Permission.LOGIN_LOG_CLEAR})
  public Object clear() {
    loginlogService.clear();
    return Rets.success();
  }
}
