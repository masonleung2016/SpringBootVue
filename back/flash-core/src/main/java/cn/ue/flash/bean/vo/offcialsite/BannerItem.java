package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:31
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class BannerItem {
    private String url = "javascript:";
    private String img;
    private String title = "";

    public BannerItem() {

    }

    public BannerItem(String url, String img, String title) {
        this.url = url;
        this.img = img;
        this.title = title;
    }
}
