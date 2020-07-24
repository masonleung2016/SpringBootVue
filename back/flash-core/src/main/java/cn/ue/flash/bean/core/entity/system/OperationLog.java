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

    public void setLogname(String bussinessName) {

    }

    public void setLogtype(String message) {

    }

    public void setUserid(int intValue) {

    }

    public void setClassname(String clazzName) {

    }

    public void setMethod(String methodName) {

    }

    public void setCreateTime(Date date) {

    }

    public void setSucceed(String message) {

    }

    public void setMessage(String msg) {

    }
}
