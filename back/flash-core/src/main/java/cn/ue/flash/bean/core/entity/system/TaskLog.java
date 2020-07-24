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
 * @Date: 2020/7/20 14:05
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Table(appliesTo = "t_sys_task_log", comment = "定时任务日志")
@Entity(name = "t_sys_task_log")
@Data
public class TaskLog {
    public static final int EXE_FAILURE_RESULT = 0;
    public static final int EXE_SUCCESS_RESULT = 1;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long idTask;
    @Column(columnDefinition = "VARCHAR(50) COMMENT '任务名'")
    private String name;

    @Column(columnDefinition = "DATETime COMMENT '执行时间'")
    private Date execAt;

    @Column(columnDefinition = "INTEGER COMMENT '执行结果（成功:1、失败:0)'")
    private int execSuccess;

    @Column(columnDefinition = "VARCHAR(500) COMMENT '抛出异常'")
    private String jobException;

    public void setName(String taskName) {

    }

    public void setExecAt(Date exeAt) {

    }

    public void setIdTask(Long id) {

    }

    public void setExecSuccess(int exeSuccessResult) {

    }

    public void setJobException(String name) {

    }
}
