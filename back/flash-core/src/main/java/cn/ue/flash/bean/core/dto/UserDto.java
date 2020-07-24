package cn.ue.flash.bean.dto;

import cn.ue.flash.bean.vo.query.SearchFilter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Description: 用户传输bean
 * @Author: LCF
 * @Date: 2020/7/20 13:56
 * @Package: cn.ue.flash.bean.dto
 * @Version 1.0
 */

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "账号不能为空")
    private String account;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String salt;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private String roleid;
    private Long deptid;
    private Long eduorgid;
    private Integer status;
    private Date createtime;
    private Integer version;
    private String avatar;


    public SearchFilter getId() {
        return null;
    }

    public String getAccount() {
        return null;
    }

    public void setSalt(String randomString) {

    }

    public String getPassword() {
        return null;
    }

    public String getSalt() {
        return null;
    }

    public void setPassword(String md5) {
    }

    public void setStatus(int code) {

    }

    public Object getName() {
        return null;
    }

    public Object getDeptid() {
        return null;
    }

    public Object getSex() {
        return null;
    }

    public Object getPhone() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public Object getBirthday() {
        return null;
    }

    public int getStatus() {
        return 0;
    }
}
