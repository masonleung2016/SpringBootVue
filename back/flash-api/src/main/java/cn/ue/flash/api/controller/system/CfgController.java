package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.system.Cfg;
import cn.ue.flash.bean.entity.system.FileInfo;
import cn.ue.flash.bean.enumeration.BizExceptionEnum;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.exception.ApplicationException;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.system.CfgService;
import cn.ue.flash.service.system.FileService;
import cn.ue.flash.service.system.LogObjectHolder;
import cn.ue.flash.utils.Maps;
import cn.ue.flash.utils.StringUtil;
import cn.ue.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:32
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/cfg")
public class CfgController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CfgService cfgService;
    @Autowired
    private FileService fileService;

    /**
     * 查询参数列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.CFG})
    public Object list(@RequestParam(required = false) String cfgName, @RequestParam(required = false) String cfgValue) {
        Page<Cfg> page = new PageFactory<Cfg>().defaultPage();
        if (StringUtil.isNotEmpty(cfgName)) {
            page.addFilter(SearchFilter.build("cfgName", SearchFilter.Operator.LIKE, cfgName));
        }
        if (StringUtil.isNotEmpty(cfgValue)) {
            page.addFilter(SearchFilter.build("cfgValue", SearchFilter.Operator.LIKE, cfgValue));
        }
        page = cfgService.queryPage(page);
        return Rets.success(page);
    }

    /**
     * 导出参数列表
     *
     * @param cfgName
     * @param cfgValue
     * @return
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.CFG})
    public Object export(@RequestParam(required = false) String cfgName, @RequestParam(required = false) String cfgValue) {
        Page<Cfg> page = new PageFactory<Cfg>().defaultPage();
        if (StringUtil.isNotEmpty(cfgName)) {
            page.addFilter(SearchFilter.build("cfgName", SearchFilter.Operator.LIKE, cfgName));
        }
        if (StringUtil.isNotEmpty(cfgValue)) {
            page.addFilter(SearchFilter.build("cfgValue", SearchFilter.Operator.LIKE, cfgValue));
        }
        page = cfgService.queryPage(page);
        FileInfo fileInfo = fileService.createExcel("templates/config.xlsx", "系统参数.xlsx", Maps.newHashMap("list", page.getRecords()));
        return Rets.success(fileInfo);
    }

    @RequestMapping(method = RequestMethod.POST)
    @BussinessLog(value = "编辑参数", key = "cfgName")
    @RequiresPermissions(value = {Permission.CFG_EDIT})
    public Object save(@ModelAttribute @Valid Cfg cfg) {
        if (cfg.getId() != null) {
            Cfg old = cfgService.get(cfg.getId());
            LogObjectHolder.me().set(old);
            old.setCfgName(cfg.getCfgName());
            old.setCfgValue(cfg.getCfgValue());
            old.setCfgDesc(cfg.getCfgDesc());
            cfgService.saveOrUpdate(old);
        } else {
            cfgService.saveOrUpdate(cfg);
        }
        return Rets.success();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "删除参数", key = "id")
    @RequiresPermissions(value = {Permission.CFG_DEL})
    public Object remove(@RequestParam Long id) {
        logger.info("id:{}", id);
        if (id == null) {
            throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
        }
        cfgService.delete(id);
        return Rets.success();
    }
}
