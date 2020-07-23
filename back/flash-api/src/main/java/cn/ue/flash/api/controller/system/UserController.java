package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.Const;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.constant.state.ManagerStatus;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.dto.UserDto;
import cn.ue.flash.bean.entity.system.User;
import cn.ue.flash.bean.enumeration.BizExceptionEnum;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.exception.ApplicationException;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.core.factory.UserFactory;
import cn.ue.flash.service.system.UserService;
import cn.ue.flash.utils.BeanUtil;
import cn.ue.flash.utils.MD5;
import cn.ue.flash.utils.RandomUtil;
import cn.ue.flash.utils.factory.Page;
import cn.ue.flash.warpper.UserWarpper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:36
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.USER})
    public Object list(@RequestParam(required = false) String account,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Long deptid,
                       @RequestParam(required = false) String phone,
                       @RequestParam(required = false) Integer status,
                       @RequestParam(required = false) Integer sex
    ) {
        Page page = new PageFactory().defaultPage();
        page.addFilter("name", SearchFilter.Operator.LIKE, name);
        page.addFilter("account", SearchFilter.Operator.LIKE, account);
        page.addFilter("deptid", deptid);
        page.addFilter("phone", phone);
        page.addFilter("status", status);
        page.addFilter("status", SearchFilter.Operator.GT, 0);
        page.addFilter("sex", sex);
        page = userService.queryPage(page);
        List list = (List) new UserWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        return Rets.success(page);
    }

    @RequestMapping(method = RequestMethod.POST)
    @BussinessLog(value = "编辑账号", key = "name")
    @RequiresPermissions(value = {Permission.USER_EDIT})
    public Object save(@Valid UserDto user, BindingResult result) {
        if (user.getId() == null) {
            // 判断账号是否重复
            User theUser = userService.findByAccount(user.getAccount());
            if (theUser != null) {
                throw new ApplicationException(BizExceptionEnum.USER_ALREADY_REG);
            }
            /** 完善账号信息*/
            user.setSalt(RandomUtil.getRandomString(5));
            user.setPassword(MD5.md5(user.getPassword(), user.getSalt()));
            user.setStatus(ManagerStatus.OK.getCode());
            userService.insert(UserFactory.createUser(user, new User()));
        } else {
            User oldUser = userService.get(user.getId());
            userService.update(UserFactory.updateUser(user, oldUser));
        }
        return Rets.success();
    }

    @BussinessLog(value = "删除账号", key = "userId")
    @RequestMapping(method = RequestMethod.DELETE)
    @RequiresPermissions(value = {Permission.USER_DEL})
    public Object remove(@RequestParam Long userId) {
        if (userId == null) {
            throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
        }
        if (userId.intValue() <= 2) {
            return Rets.failure("不能删除初始用户");
        }
        User user = userService.get(userId);
        user.setStatus(ManagerStatus.DELETED.getCode());
        userService.update(user);
        return Rets.success();
    }

    @BussinessLog(value = "设置账号角色", key = "userId")
    @RequestMapping(value = "/setRole", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.USER_EDIT})
    public Object setRole(@RequestParam("userId") Long userId, @RequestParam("roleIds") String roleIds) {
        if (BeanUtil.isOneEmpty(userId, roleIds)) {
            throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
        }
        //不能修改超级管理员
        if (userId.intValue() == Const.ADMIN_ID.intValue()) {
            throw new ApplicationException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
        User user = userService.get(userId);
        user.setRoleid(roleIds);
        userService.update(user);
        return Rets.success();
    }

    @BussinessLog(value = "冻结/解冻账号", key = "userId")
    @RequestMapping(value = "changeStatus", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.USER_EDIT})
    public Object changeStatus(@RequestParam Long userId) {
        if (userId == null) {
            throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = userService.get(userId);
        user.setStatus(user.getStatus().intValue() == ManagerStatus.OK.getCode() ? ManagerStatus.FREEZED.getCode() : ManagerStatus.OK.getCode());
        userService.update(user);
        return Rets.success();
    }

}
