package cn.ue.flash.bean.entity.system;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Transient;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:02
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Data
@Entity(name = "t_sys_file_info")
@Table(appliesTo = "t_sys_file_info", comment = "文件")
@EntityListeners(AuditingEntityListener.class)
public class FileInfo extends BaseEntity {
    @Column
    private String originalFileName;
    @Column
    private String realFileName;
    @Transient
    private String ablatePath;

}
