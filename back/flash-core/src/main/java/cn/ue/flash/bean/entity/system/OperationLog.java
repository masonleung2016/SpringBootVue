package cn.ue.flash.bean.entity.system;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:04
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_operation_log")
@Table(appliesTo = "t_sys_operation_log", comment = "操作日志")
@Data
public class OperationLog {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String logtype;
  @Column
  private String logname;
  @Column
  private Integer userid;
  @Column
  private String classname;
  @Column
  private String method;
  @Column(name = "create_time")
  private Date createTime;
  @Column
  private String succeed;
  @Column(columnDefinition = "TEXT COMMENT '详细信息'")
  private String message;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogtype() {
    return logtype;
  }

  public void setLogtype(String message) {

  }

  public String getLogname() {
    return logname;
  }

  public void setLogname(String bussinessName) {

  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(int intValue) {

  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getClassname() {
    return classname;
  }

  public void setClassname(String clazzName) {

  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String methodName) {

  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date date) {

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
}
