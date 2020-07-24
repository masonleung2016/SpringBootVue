package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:32
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class Reply {
    private String content;
    private Date createAt;
    private Author author;
}
