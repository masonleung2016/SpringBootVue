package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.constant.factory.PageFactory;
import cn.ue.flash.bean.constant.state.BizLogType;
import cn.ue.flash.bean.core.BussinessLog;
import cn.ue.flash.bean.entity.system.OperationLog;
import cn.ue.flash.bean.enumeration.Permission;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.service.system.OperationLogService;
import cn.ue.flash.utils.BeanUtil;
import cn.ue.flash.utils.DateUtil;
import cn.ue.flash.utils.HttpUtil;
import cn.ue.flash.utils.StringUtil;
import cn.ue.flash.utils.factory.Page;
import cn.ue.flash.warpper.LogWarpper;
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
@RequestMapping("/log")
public class LogController extends BaseController {
    @Autowired
    private OperationLogService operationLogService;

    /**
     * 查询操作日志列表
     */
    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions(value = {Permission.LOG})
    public Object list(@RequestParam(required = false) String beginTime,
                       @RequestParam(required = false) String endTime,
                       @RequestParam(required = false) String logName,
                       @RequestParam(required = false) Integer logType) {
        Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        if (StringUtil.isNotEmpty(beginTime)) {
            page.addFilter("createTime", SearchFilter.Operator.GTE, DateUtil.parseDate(beginTime));
        }
        if (StringUtil.isNotEmpty(endTime)) {
            page.addFilter("createTime", SearchFilter.Operator.LTE, DateUtil.parseDate(endTime));
        }
        page.addFilter("logname", SearchFilter.Operator.LIKE, logName);
        if (logType != null) {
            page.addFilter(SearchFilter.build("logtype", SearchFilter.Operator.EQ, BizLogType.valueOf(logType)));
        }
        page = operationLogService.queryPage(page);
        page.setRecords((List<OperationLog>) new LogWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp());
        return Rets.success(page);
    }

    /**
     * 查询指定用户的操作日志列表
     */
    @RequestMapping("/queryByUser")
    @ResponseBody
    public Object list() {
        Page<OperationLog> page = new Page<OperationLog>();
        page.addFilter(SearchFilter.build("userid", SearchFilter.Operator.EQ, getIdUser(HttpUtil.getRequest())));
        Page<OperationLog> pageResult = operationLogService.queryPage(page);
        return Rets.success(pageResult.getRecords());
    }

    /**
     * 清空日志
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "清空业务日志")
    @RequiresPermissions(value = {Permission.LOG_CLEAR})
    public Object delLog() {
        operationLogService.clear();
        return Rets.success();
    }
}
