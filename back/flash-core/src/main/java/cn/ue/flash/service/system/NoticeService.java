package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.Notice;
import cn.ue.flash.dao.system.NoticeRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:17
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

@Service
public class NoticeService extends BaseService<Notice, Long, NoticeRepository> {
    @Autowired
    private NoticeRepository noticeRepository;

    public List<Notice> findByTitleLike(String title) {
        return noticeRepository.findByTitleLike("%" + title + "%");
    }
}
