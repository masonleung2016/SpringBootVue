package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.system.Dept;
import cn.ue.flash.bean.enumeration.BizExceptionEnum;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.exception.ApplicationException;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.node.DeptNode;
import cn.ue.flash.service.system.DeptService;
import cn.ue.flash.service.system.LogObjectHolder;
import cn.ue.flash.utils.BeanUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:33
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/dept")
public class DeptContoller extends BaseController {
  private Logger logger = LoggerFactory.getLogger(MenuController.class);

  @Autowired
  private DeptService deptService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.DEPT})
  public Object list() {
    List<DeptNode> list = deptService.queryAllNode();
    return Rets.success(list);
  }

  @RequestMapping(method = RequestMethod.POST)
  @BussinessLog(value = "编辑部门", key = "simplename")
  @RequiresPermissions(value = {Permission.DEPT_EDIT})
  public Object save(@ModelAttribute @Valid Dept dept) {
    if (BeanUtil.isOneEmpty(dept, dept.getSimplename())) {
      throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
    }
    if (dept.getId() != null) {
      Dept old = deptService.get(dept.getId());
      LogObjectHolder.me().set(old);
      old.setPid(dept.getPid());
      old.setSimplename(dept.getSimplename());
      old.setFullname(dept.getFullname());
      old.setNum(dept.getNum());
      old.setTips(dept.getTips());
      deptService.deptSetPids(old);
      deptService.update(old);
    } else {
      deptService.deptSetPids(dept);
      deptService.insert(dept);
    }
    return Rets.success();
  }

  @RequestMapping(method = RequestMethod.DELETE)
  @BussinessLog(value = "删除部门", key = "id")
  @RequiresPermissions(value = {Permission.DEPT_DEL})
  public Object remove(@RequestParam Long id) {
    logger.info("id:{}", id);
    if (id == null) {
      throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
    }
    deptService.deleteDept(id);
    return Rets.success();
  }
}
