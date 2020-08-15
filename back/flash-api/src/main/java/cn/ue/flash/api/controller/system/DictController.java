package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.system.Dict;
import cn.ue.flash.bean.enumeration.BizExceptionEnum;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.exception.ApplicationException;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.cache.DictCache;
import cn.ue.flash.service.system.DictService;
import cn.ue.flash.utils.BeanUtil;
import cn.ue.flash.utils.StringUtil;
import cn.ue.flash.warpper.DictWarpper;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:33
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
  @Autowired
  private DictService dictService;
  @Autowired
  private DictCache dictCache;

  /**
   * 获取所有字典列表
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @RequiresPermissions(value = {Permission.DICT})
  public Object list(String name) {

    if (StringUtil.isNotEmpty(name)) {
      List<Dict> list = dictService.findByNameLike(name);
      return Rets.success(new DictWarpper(BeanUtil.objectsToMaps(list)).warp());
    }
    List<Dict> list = dictService.findByPid(0L);
    return Rets.success(new DictWarpper(BeanUtil.objectsToMaps(list)).warp());
  }

  @RequestMapping(method = RequestMethod.POST)
  @BussinessLog(value = "添加字典", key = "dictName")
  @RequiresPermissions(value = {Permission.DICT_EDIT})
  public Object add(String dictName, String dictValues) {
    if (BeanUtil.isOneEmpty(dictName, dictValues)) {
      throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
    }
    dictService.addDict(dictName, dictValues);
    return Rets.success();
  }

  @RequestMapping(method = RequestMethod.PUT)
  @BussinessLog(value = "修改字典", key = "dictName")
  @RequiresPermissions(value = {Permission.DICT_EDIT})
  public Object update(Long id, String dictName, String dictValues) {
    if (BeanUtil.isOneEmpty(dictName, dictValues)) {
      throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
    }
    dictService.editDict(id, dictName, dictValues);
    return Rets.success();
  }


  @RequestMapping(method = RequestMethod.DELETE)
  @BussinessLog(value = "删除字典", key = "id")
  @RequiresPermissions(value = {Permission.DICT_EDIT})
  public Object delete(@RequestParam Long id) {
    dictService.delteDict(id);
    return Rets.success();
  }

  @RequestMapping(value = "/getDicts/{dictName}", method = RequestMethod.GET)
  public Object getDicts(@PathVariable("dictName") String dictName) {
    List<Dict> dicts = dictCache.getDictsByPname(dictName);
    return Rets.success(dicts);
  }
}
