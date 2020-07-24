package cn.ue.flash.bean.entity.test;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Description: 该实体用于测试生成代码
 * @Author: LCF
 * @Date: 2020/7/20 14:06
 * @Package: cn.ue.flash.bean.entity.test
 * @Version 1.0
 */

@Entity(name = "t_test_boy")
@Table(appliesTo = "t_test_boy", comment = "男孩")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Boy extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(32) COMMENT '姓名'")
    private String name;
    @Column(columnDefinition = "INT COMMENT '年龄'")
    private Integer age;
    @Column(columnDefinition = "VARCHAR(12) COMMENT '生日'")
    private String birthday;
    @Column(name = "has_girl_friend", columnDefinition = "TINYINT COMMENT '是否有女朋友'")
    private Boolean hasGirFriend;
}
