package cn.ue.flash.bean.entity.system;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:03
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_menu")
@Table(appliesTo = "t_sys_menu", comment = "菜单")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Menu extends BaseEntity {
  @Column(columnDefinition = "VARCHAR(32) COMMENT '编号'", unique = true, nullable = false)
  @NotBlank(message = "编号不能为空")
  private String code;
  @Column(columnDefinition = "VARCHAR(64) COMMENT '父菜单编号'", nullable = false)
  private String pcode;
  @Column(columnDefinition = "VARCHAR(128) COMMENT '递归父级菜单编号'")
  private String pcodes;
  @Column(columnDefinition = "VARCHAR(64) COMMENT '名称'", nullable = false)
  @NotBlank(message = "名称不能为空")
  private String name;
  @Column(columnDefinition = "VARCHAR(32) COMMENT '图标'")
  private String icon;
  /**
   * 如果当前配置为非菜单（按钮）也需要配置链接，v-permission使用该配置，且不能与其他url重复
   */
  @Column(columnDefinition = "VARCHAR(32) COMMENT '链接标识'")
  private String url;
  @Column(columnDefinition = "INT COMMENT '顺序'", nullable = false)
  private Integer num;
  @Column(columnDefinition = "INT COMMENT '级别'", nullable = false)
  private Integer levels;
  @Column(columnDefinition = "INT COMMENT '是否是菜单1:菜单,0:按钮'", nullable = false)
  private Integer ismenu;
  @Column(columnDefinition = "VARCHAR(32) COMMENT '鼠标悬停提示信息'")
  private String tips;
  @Column(columnDefinition = "INT COMMENT '状态1:启用,0:禁用'", nullable = false)
  private Integer status;
  @Column(columnDefinition = "INT  COMMENT '是否默认打开1:是,0:否'")
  private Integer isopen;
  @Column(columnDefinition = "VARCHAR(64) COMMENT '页面组件'")
  private String component;
  @Column(columnDefinition = "tinyint COMMENT '是否隐藏'")
  private Boolean hidden = false;

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

  public void setNum(Integer num) {
    this.num = num;
  }

  @Override
  public Object getTips() {
    return null;
  }

  @Override
  public void setTips(Object tips) {

  }

  public void setTips(String tips) {
    this.tips = tips;
  }

  @Override
  public String getCode() {
    return null;
  }

  public void setCode(String code) {
    this.code = code;
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
  public void setSex(Object sex) {

  }

  @Override
  public void setPhone(Object phone) {

  }

  @Override
  public void setEmail(Object email) {

  }

  @Override
  public void setBirthday(Object birthday) {

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

  public void setLevels(Integer levels) {
    this.levels = levels;
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

  @Override
  public void setCreateBy(Long userId) {

  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getIsmenu() {
    return ismenu;
  }

  public void setIsmenu(Integer ismenu) {
    this.ismenu = ismenu;
  }

  public Integer getIsopen() {
    return isopen;
  }

  public void setIsopen(Integer isopen) {
    this.isopen = isopen;
  }

  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public Boolean getHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }
}
