package cn.ue.flash.api.controller.front.officialsite;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:28
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@Data
public class Contact {
    public String username;
    private String email;
    private String mobile;
    private String description;
    private Date createAt;
}
