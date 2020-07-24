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

    public void setIndex(int i) {

    }

    public void setList(List<Banner> bannerList) {

    }
}
