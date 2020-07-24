package cn.ue.flash.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:07
 * @Package: cn.ue.flash.bean.entity
 * @Version 1.0
 */

@MappedSuperclass
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间/注册时间'", updatable = false)
    private Date createTime;
    @Column(name = "create_by", columnDefinition = "bigint COMMENT '创建人'", updatable = false)
    @CreatedBy
    private Long createBy;
    @LastModifiedDate
    @Column(name = "modify_time", columnDefinition = "DATETIME COMMENT '最后更新时间'")
    private Date modifyTime;
    @LastModifiedBy
    @Column(name = "modify_by", columnDefinition = "bigint COMMENT '最后更新人'")
    private Long modifyBy;

    public abstract String getOriginalFileName();

    public abstract void setOriginalFileName(String originalFileName);

    public abstract String getAblatePath();

    public abstract void setAblatePath(String s);

    public abstract String getRealFileName();

    public abstract void setRealFileName(String name);

    public abstract String getSalt();

    public abstract byte[] getPassword();

    public abstract void setPassword(String md5);

    public abstract String getRoleid();

    public abstract void setRoleid(String roleIds);

    public abstract Long getId();

    public abstract Object getName();

    public abstract void setName(Object name);

    public abstract String getAccount();

    public abstract void setAccount(String admin);

    public abstract Object getCfgName();

    public abstract void setCfgName(Object cfgName);

    public abstract Object getCfgValue();

    public abstract void setCfgValue(Object cfgValue);

    public abstract Object getCfgDesc();

    public abstract void setCfgDesc(Object cfgDesc);

    public abstract Object getAuthor();

    public abstract void setAuthor(Object author);

    public abstract Object getContent();

    public abstract void setContent(Object content);

    public abstract Object getIdChannel();

    public abstract void setIdChannel(Object idChannel);

    public abstract Object getImg();

    public abstract void setImg(Object img);

    public abstract Object getTitle();

    public abstract void setTitle(Object title);

    public abstract Object getSimplename();

    public abstract void setSimplename(Object simplename);

    public abstract int getPid();

    public abstract void setPid(Object pid);

    public abstract Object getFullname();

    public abstract void setFullname(Object fullname);

    public abstract Object getNum();

    public abstract void setNum(Object num);

    public abstract Object getTips();

    public abstract void setTips(Object tips);

    public abstract String getCode();

    public abstract Object getCron();

    public abstract void setCron(Object cron);

    public abstract Object getJobClass();

    public abstract void setJobClass(Object jobClass);

    public abstract Object getNote();

    public abstract void setNote(Object note);

    public abstract Object getData();

    public abstract void setData(Object data);

    public abstract int getStatus();

    public abstract void setStatus(int code);

    public abstract void setDeptid(Object deptid);

    public abstract void setSex(Object sex);

    public abstract void setPhone(Object phone);

    public abstract void setEmail(Object email);

    public abstract void setBirthday(Object birthday);

    public abstract String getCreateTime();

    public abstract void setCreateTime(Date date);

    public abstract void setType(Integer type);

    public abstract void setState(int i);

    public abstract void setReceiver(String receiver);

    public abstract String getClassName();

    public abstract String getTplCode();

    public abstract void setTplCode(String tplCode);

    public abstract String getPids();

    public abstract void setPids(String s);

    public abstract void setCreateBy(Long userId);

    public abstract String getPcode();

    public abstract void setPcode(String s);

    public abstract void setPcodes(String s);

    public abstract void setLevels(int i);

    public abstract Integer getLevels();

    public abstract String getPcodes();

    public abstract void setExecResult(String exeResult);

    public abstract void setExecAt(Date exeAt);

    public abstract String getJobGroup();

    public abstract Object isConcurrent();

    public abstract boolean isDisabled();

    public abstract void setDisabled(boolean b);

    public abstract Long getDeptid();

}

