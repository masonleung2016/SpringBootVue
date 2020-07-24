package cn.ue.flash.bean.entity.cms;

import cn.ue.flash.bean.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:58
 * @Package: cn.ue.flash.bean.entity.cms
 * @Version 1.0
 */

@Entity(name = "t_cms_contacts")
@Data
@Table(appliesTo = "t_cms_contacts", comment = "邀约信息")
public class Contacts extends BaseEntity {
    @Column(columnDefinition = "VARCHAR(64) COMMENT '邀约人名称'")
    @NotBlank(message = "名称不能为空")
    private String userName;
    @Column(columnDefinition = "VARCHAR(64) COMMENT '联系电话'")
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    @Column(columnDefinition = "VARCHAR(32) COMMENT '电子邮箱'")
    @NotBlank(message = "电子邮箱不能为空")
    private String email;
    @Column(columnDefinition = "VARCHAR(128) COMMENT '备注'")
    private String remark;
}
