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

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccount() {
    return null;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return null;
  }

  public void setPassword(String md5) {
  }

  public String getSalt() {
    return null;
  }

  public void setSalt(String randomString) {

  }

  public Object getName() {
    return null;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getDeptid() {
    return null;
  }

  public void setDeptid(Long deptid) {
    this.deptid = deptid;
  }

  public Object getSex() {
    return null;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Object getPhone() {
    return null;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Object getEmail() {
    return null;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Object getBirthday() {
    return null;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public int getStatus() {
    return 0;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public void setStatus(int code) {

  }

  public String getRoleid() {
    return roleid;
  }

  public void setRoleid(String roleid) {
    this.roleid = roleid;
  }

  public Long getEduorgid() {
    return eduorgid;
  }

  public void setEduorgid(Long eduorgid) {
    this.eduorgid = eduorgid;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
