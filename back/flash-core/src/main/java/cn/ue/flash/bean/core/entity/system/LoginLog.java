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

    public void setLogname(String message) {

    }

    public void setUserid(int intValue) {

    }

    public void setCreateTime(Date date) {

    }

    public void setSucceed(String message) {

    }

    public void setIp(String ip) {

    }

    public void setMessage(String msg) {

    }
}
