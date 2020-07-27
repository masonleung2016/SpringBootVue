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
 * @Date: 2020/7/20 14:01
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_cfg")
@Table(appliesTo = "t_sys_cfg", comment = "系统参数")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Cfg extends BaseEntity {
  @NotBlank(message = "参数名并能为空")
  @Column(name = "cfg_name", columnDefinition = "VARCHAR(256) COMMENT '参数名'")
  private String cfgName;
  @NotBlank(message = "参数值不能为空")
  @Column(name = "cfg_value", columnDefinition = "VARCHAR(512) COMMENT '参数值'")
  private String cfgValue;
  @Column(name = "cfg_desc", columnDefinition = "TEXT COMMENT '备注'")
  private String cfgDesc;

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

  public void setCfgName(String cfgName) {
    this.cfgName = cfgName;
  }

  @Override
  public Object getCfgValue() {
    return null;
  }

  @Override
  public void setCfgValue(Object cfgValue) {

  }

  public void setCfgValue(String cfgValue) {
    this.cfgValue = cfgValue;
  }

  @Override
  public Object getCfgDesc() {
    return null;
  }

  @Override
  public void setCfgDesc(Object cfgDesc) {

  }

  public void setCfgDesc(String cfgDesc) {
    this.cfgDesc = cfgDesc;
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
}
