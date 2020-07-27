package cn.ue.flash.bean.entity.system;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:03
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_login_log")
@Table(appliesTo = "t_sys_login_log", comment = "登录日志")
@Data
public class LoginLog {
  @Id
  @GeneratedValue
  private Integer id;
  @Column
  private String logname;
  @Column
  private Integer userid;
  @Column
  private String succeed;
  @Column
  private String message;
  @Column
  private String ip;
  @CreationTimestamp
  @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
  private Date createTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLogname() {
    return logname;
  }

  public void setLogname(String message) {

  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(int intValue) {

  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getSucceed() {
    return succeed;
  }

  public void setSucceed(String message) {

  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String msg) {

  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {

  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date date) {

  }
}
