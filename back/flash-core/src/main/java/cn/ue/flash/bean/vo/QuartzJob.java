package cn.ue.flash.bean.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:36
 * @Package: cn.ue.flash.bean.vo
 * @Version 1.0
 */

@Getter
@Setter
public class QuartzJob implements Serializable {
  private String jobId;
  private String jobName;
  private String jobGroup;
  private String jobClass;
  private String description;
  private String cronExpression;
  private boolean concurrent;
  private String jobStatus;
  private Date nextTime;
  private Date previousTime;
  private boolean disabled;
  private Map<String, Object> dataMap;

  public Map getDataMap() {
    return null;
  }

  public void setDataMap(Map<String, Object> dataMap) {

  }

  public String getJobName() {
    return null;
  }

  public void setJobName(String jobName) {

  }

  public Object getDescription() {
    return null;
  }

  public void setDescription(String s) {

  }

  public boolean isDisabled() {
    return false;
  }

  public void setDisabled(Object disabled) {

  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public String getCronExpression() {
    return null;
  }

  public void setCronExpression(String cronExpression) {

  }

  public String getJobGroup() {
    return null;
  }

  public void setJobGroup(String jobGroup) {

  }

  public boolean isConcurrent() {
    return false;
  }

  public void setConcurrent(Object concurrent) {

  }

  public void setConcurrent(boolean concurrent) {
    this.concurrent = concurrent;
  }

  public String getJobClass() {
    return null;
  }

  public void setJobClass(Object jobClass) {

  }

  public void setJobClass(String jobClass) {
    this.jobClass = jobClass;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String name) {

  }

  public Date getNextTime() {
    return nextTime;
  }

  public void setNextTime(Date nextFireTime) {

  }

  public Date getPreviousTime() {
    return previousTime;
  }

  public void setPreviousTime(Date previousFireTime) {

  }
}
