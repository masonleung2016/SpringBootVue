package cn.ue.flash.api.controller.cms;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.entity.system.FileInfo;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.system.FileService;
import cn.ue.flash.utils.StringUtil;
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
 * @Date: 2020/7/20 13:27
 * @Package: cn.ue.flash.api.controller.cms
 * @Version 1.0
 */

@RestController
@RequestMapping("/fileMgr")
public class FileMgrController extends BaseController {

  @Autowired
  private FileService fileService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.FILE})
  public Object list(@RequestParam(required = false) String originalFileName
  ) {
    Page<FileInfo> page = new PageFactory<FileInfo>().defaultPage();
    if (StringUtil.isNotEmpty(originalFileName)) {
      page.addFilter(SearchFilter.build("originalFileName", SearchFilter.Operator.LIKE, originalFileName));
    }
    page = fileService.queryPage(page);
    return Rets.success(page);
  }
}
