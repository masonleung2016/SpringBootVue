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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
