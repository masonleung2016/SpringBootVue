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
public class News {
    /**
     * 资讯标题
     */
    private String desc;
    /**
     * 详情链接
     */
    private String url;
    /**
     * 图片地址
     */
    private String src;

    public News() {

    }

    public News(String desc, String url, String src) {
        this.desc = desc;
        this.url = url;
        this.src = src;
    }

    public void setDesc(Object title) {

    }

    public void setUrl(String s) {

    }

    public void setSrc(String s) {

    }
}
