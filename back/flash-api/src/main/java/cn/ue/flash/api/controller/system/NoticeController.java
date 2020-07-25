package cn.ue.flash.api.controller.system;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.system.Notice;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.service.system.NoticeService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:35
 * @Package: cn.ue.flash.api.controller.system
 * @Version 1.0
 */

@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 获取通知列表
     */
    @RequestMapping(value = "/list")
    public Object list(String condition) {
        List<Notice> list = null;
        if (Strings.isNullOrEmpty(condition)) {
            list = noticeService.queryAll();
        } else {
            list = noticeService.findByTitleLike(condition);
        }
        return Rets.success(list);
    }
}
