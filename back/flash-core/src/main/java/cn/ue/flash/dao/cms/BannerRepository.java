package cn.ue.flash.dao.cms;

import cn.ue.flash.bean.entity.cms.Banner;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description: 查询指定类别的banner列表
 * @Author: LCF
 * @Date: 2020/7/20 14:47
 * @Package: cn.ue.flash.dao.cms
 * @Version 1.0
 */

public interface BannerRepository extends BaseRepository<Banner, Long> {
  /**
   * @param type
   * @return
   */
  List<Banner> findAllByType(String type);
}
