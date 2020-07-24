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

    public String getJobName() {
        return null;
    }

    public void setJobName(String jobName) {

    }

    public void setJobGroup(String jobGroup) {

    }

    public void setDescription(String s) {

    }

    public void setNextTime(Date nextFireTime) {

    }

    public void setPreviousTime(Date previousFireTime) {

    }

    public void setJobStatus(String name) {

    }

    public void setCronExpression(String cronExpression) {

    }

    public void setConcurrent(Object concurrent) {

    }

    public void setJobClass(Object jobClass) {

    }

    public void setDisabled(Object disabled) {

    }

    public void setDataMap(Map<String, Object> dataMap) {

    }

    public Object getDescription() {
        return null;
    }

    public boolean isDisabled() {
        return false;
    }

    public String getCronExpression() {
        return null;
    }

    public String getJobGroup() {
        return null;
    }

    public boolean isConcurrent() {
        return false;
    }

    public String getJobClass() {
        return null;
    }
}
