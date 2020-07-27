package cn.ue.flash.bean.vo.offcialsite;

import cn.ue.flash.bean.entity.cms.Banner;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:31
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class BannerVo {
  private Integer index = 0;
  private List<Banner> list;

  public Integer getIndex() {
    return index;
  }

  public void setIndex(int i) {

  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public List<Banner> getList() {
    return list;
  }

  public void setList(List<Banner> bannerList) {

  }
}