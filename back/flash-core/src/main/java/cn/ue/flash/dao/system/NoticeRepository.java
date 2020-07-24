package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Notice;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:51
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface NoticeRepository extends BaseRepository<Notice, Long> {
    List<Notice> findByTitleLike(String name);
}

