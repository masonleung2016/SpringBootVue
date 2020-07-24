package cn.ue.flash.bean.entity.system;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:01
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_dept")
@Table(appliesTo = "t_sys_dept", comment = "部门")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Dept extends BaseEntity {
    @Column
    private Integer num;
    @Column
    private Long pid;
    @Column
    private String pids;
    @Column
    @NotBlank(message = "部门简称不能为空")
    private String simplename;
    @Column
    @NotBlank(message = "部门全称不能为空")
    private String fullname;
    @Column
    private String tips;
    @Column
    private Integer version;
}
