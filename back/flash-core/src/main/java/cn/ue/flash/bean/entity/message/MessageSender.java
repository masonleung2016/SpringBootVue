package cn.ue.flash.bean.entity.message;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Description: 消息发送者
 * @Author: LCF
 * @Date: 2020/7/20 14:00
 * @Package: cn.ue.flash.bean.entity.message
 * @Version 1.0
 */

@Data
@Entity(name = "t_message_sender")
@Table(appliesTo = "t_message_sender", comment = "消息发送者")
public class MessageSender extends BaseEntity {
  @Column(name = "name", columnDefinition = "VARCHAR(64) COMMENT '名称'")
  @NotBlank(message = "名称并能为空")
  private String name;
  @Column(name = "class_name", columnDefinition = "VARCHAR(64) COMMENT '发送类'")
  @NotBlank(message = "发送类不能为空")
  private String className;
  @Column(name = "tpl_code", columnDefinition = "VARCHAR(64) COMMENT '短信运营商模板编号'")
  private String tplCode;

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

  public void setClassName(String className) {
    this.className = className;
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
