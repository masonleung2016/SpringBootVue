package cn.ue.flash.service.cms;

import cn.ue.flash.bean.entity.cms.Banner;
import cn.ue.flash.bean.enumeration.cms.BannerTypeEnum;
import cn.ue.flash.bean.vo.offcialsite.BannerVo;
import cn.ue.flash.dao.cms.BannerRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:02
 * @Package: cn.ue.flash.service.cms
 * @Version 1.0
 */

@Service
public class BannerService extends BaseService<Banner, Long, BannerRepository> {
  @Autowired
  private BannerRepository bannerRepository;

  /**
   * 查询首页banner数据
   *
   * @return
   */
  public BannerVo queryIndexBanner() {
    return queryBanner(BannerTypeEnum.INDEX.getValue());
  }

  public BannerVo queryBanner(String type) {
    BannerVo banner = new BannerVo();
    List<Banner> bannerList = bannerRepository.findAllByType(type);
    banner.setIndex(0);
    banner.setList(bannerList);
    return banner;
  }

  public BannerRepository getBannerRepository() {
    return bannerRepository;
  }

  public void setBannerRepository(BannerRepository bannerRepository) {
    this.bannerRepository = bannerRepository;
  }
}
