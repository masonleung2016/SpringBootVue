package cn.ue.flash.bean.entity.system;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:06
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_user")
@Table(appliesTo = "t_sys_user", comment = "账号")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {
  @Column(columnDefinition = "varchar(64) comment '头像'")
  private String avatar;
  @Column(columnDefinition = "VARCHAR(32) COMMENT '账户'")
  private String account;
  @Column(columnDefinition = "VARCHAR(64) COMMENT '密码'")
  private String password;
  @Column(columnDefinition = "VARCHAR(16) COMMENT '密码盐'")
  private String salt;
  @Column(columnDefinition = "VARCHAR(64) COMMENT '姓名'")
  private String name;
  @Column(columnDefinition = "DATE COMMENT '生日'")
  private Date birthday;
  @Column(columnDefinition = "INT COMMENT '性别:1:男,2:女'")
  private Integer sex;
  @Column(columnDefinition = "VARCHAR(64) COMMENT 'email'")
  private String email;
  @Column(columnDefinition = "VARCHAR(16) COMMENT '手机号'")
  private String phone;
  @Column(columnDefinition = "VARCHAR(128) COMMENT '角色id列表，以逗号分隔'")
  private String roleid;
  @Column(columnDefinition = "BIGINT COMMENT '部门id'")
  private Long deptid;
  @Column(columnDefinition = "INT COMMENT '状态1:启用,2:禁用'")
  private Integer status;
  @Column(columnDefinition = "INT COMMENT '版本'")
  private Integer version;
  @JoinColumn(name = "deptid", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  @ManyToOne(fetch = FetchType.EAGER)
  private Dept dept;

  @Override
  public String getOriginalFileName() {
    return null;
  }

  @Override
  public void setOriginalFileName(String originalFileName) {

  }

  @Override
  public String getAblatePath() {
    return null;
  }

  @Override
  public void setAblatePath(String s) {

  }

  @Override
  public String getRealFileName() {
    return null;
  }

  @Override
  public void setRealFileName(String name) {

  }

  @Override
  public String getSalt() {
    return null;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  @Override
  public byte[] getPassword() {
    return new byte[0];
  }

  @Override
  public void setPassword(String md5) {

  }

  @Override
  public String getRoleid() {
    return null;
  }

  @Override
  public void setRoleid(String roleIds) {

  }

  @Override
  public Long getId() {
    return null;
  }

  @Override
  public Object getName() {
    return null;
  }

  @Override
  public void setName(Object name) {

  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getAccount() {
    return null;
  }

  @Override
  public void setAccount(String admin) {

  }

  @Override
  public Object getCfgName() {
    return null;
  }

  @Override
  public void setCfgName(Object cfgName) {

  }

  @Override
  public Object getCfgValue() {
    return null;
  }

  @Override
  public void setCfgValue(Object cfgValue) {

  }

  @Override
  public Object getCfgDesc() {
    return null;
  }

  @Override
  public void setCfgDesc(Object cfgDesc) {

  }

  @Override
  public Object getAuthor() {
    return null;
  }

  @Override
  public void setAuthor(Object author) {

  }

  @Override
  public Object getContent() {
    return null;
  }

  @Override
  public void setContent(Object content) {

  }

  @Override
  public Object getIdChannel() {
    return null;
  }

  @Override
  public void setIdChannel(Object idChannel) {

  }

  @Override
  public Object getImg() {
    return null;
  }

  @Override
  public void setImg(Object img) {

  }

  @Override
  public Object getTitle() {
    return null;
  }

  @Override
  public void setTitle(Object title) {

  }

  @Override
  public Object getSimplename() {
    return null;
  }

  @Override
  public void setSimplename(Object simplename) {

  }

  @Override
  public int getPid() {
    return 0;
  }

  @Override
  public void setPid(Object pid) {

  }

  @Override
  public Object getFullname() {
    return null;
  }

  @Override
  public void setFullname(Object fullname) {

  }

  @Override
  public Object getNum() {
    return null;
  }

  @Override
  public void setNum(Object num) {

  }

  @Override
  public Object getTips() {
    return null;
  }

  @Override
  public void setTips(Object tips) {

  }

  @Override
  public String getCode() {
    return null;
  }

  @Override
  public Object getCron() {
    return null;
  }

  @Override
  public void setCron(Object cron) {

  }

  @Override
  public Object getJobClass() {
    return null;
  }

  @Override
  public void setJobClass(Object jobClass) {

  }

  @Override
  public Object getNote() {
    return null;
  }

  @Override
  public void setNote(Object note) {

  }

  @Override
  public Object getData() {
    return null;
  }

  @Override
  public void setData(Object data) {

  }

  @Override
  public int getStatus() {
    return 0;
  }

  @Override
  public void setStatus(int code) {

  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String getCreateTime() {
    return null;
  }

  @Override
  public void setCreateTime(Date date) {

  }

  @Override
  public void setType(Integer type) {

  }

  @Override
  public void setState(int i) {

  }

  @Override
  public void setReceiver(String receiver) {

  }

  @Override
  public String getClassName() {
    return null;
  }

  @Override
  public String getTplCode() {
    return null;
  }

  @Override
  public void setTplCode(String tplCode) {

  }

  @Override
  public String getPids() {
    return null;
  }

  @Override
  public void setPids(String s) {

  }

  @Override
  public String getPcode() {
    return null;
  }

  @Override
  public void setPcode(String s) {

  }

  @Override
  public Integer getLevels() {
    return null;
  }

  @Override
  public void setLevels(int i) {

  }

  @Override
  public String getPcodes() {
    return null;
  }

  @Override
  public void setPcodes(String s) {

  }

  @Override
  public void setExecResult(String exeResult) {

  }

  @Override
  public void setExecAt(Date exeAt) {

  }

  @Override
  public String getJobGroup() {
    return null;
  }

  @Override
  public Object isConcurrent() {
    return null;
  }

  @Override
  public boolean isDisabled() {
    return false;
  }

  @Override
  public void setDisabled(boolean b) {

  }

  @Override
  public Long getDeptid() {
    return null;
  }

  @Override
  public void setDeptid(Object deptid) {

  }

  public void setDeptid(Long deptid) {
    this.deptid = deptid;
  }

  @Override
  public void setCreateBy(Long userId) {

  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Date getBirthday() {
    return birthday;
  }

  @Override
  public void setBirthday(Object birthday) {

  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getSex() {
    return sex;
  }

  @Override
  public void setSex(Object sex) {

  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(Object email) {

  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public void setPhone(Object phone) {

  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }
}
