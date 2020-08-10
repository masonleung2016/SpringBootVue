package cn.ue.flash.api.controller.cms;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.cms.Banner;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.cms.BannerService;
import cn.ue.flash.utils.StringUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: banner管理
 * @Author: LCF
 * @Date: 2020/7/20 13:25
 * @Package: cn.ue.flash.api.controller.cms
 * @Version 1.0
 */

@RestController
@RequestMapping("/banner")
public class BannerMgrController extends BaseController {
  @Autowired
  private BannerService bannerService;

  @RequestMapping(method = RequestMethod.POST)
  @BussinessLog(value = "编辑banner", key = "title")
  @RequiresPermissions(value = {Permission.BANNER_EDIT})
  public Object save(@ModelAttribute @Valid Banner banner) {
    if (banner.getId() == null) {
      bannerService.insert(banner);
    } else {
      bannerService.update(banner);
    }
    return Rets.success();
  }

  @RequestMapping(method = RequestMethod.DELETE)
  @BussinessLog(value = "删除banner", key = "id")
  @RequiresPermissions(value = {Permission.BANNER_DEL})
  public Object remove(Long id) {
    bannerService.delete(id);
    return Rets.success();
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.BANNER})
  public Object list(@RequestParam(required = false) String title) {
    SearchFilter filter = null;
    if (StringUtil.isNotEmpty(title)) {
      filter = SearchFilter.build("title", SearchFilter.Operator.LIKE, title);
    }
    List<Banner> list = bannerService.queryAll(filter);
    return Rets.success(list);
  }
}
