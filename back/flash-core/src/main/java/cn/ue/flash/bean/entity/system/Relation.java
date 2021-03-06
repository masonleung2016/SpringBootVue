package cn.ue.flash.bean.entity.system;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:04
 * @Package: cn.ue.flash.bean.entity.system
 * @Version 1.0
 */

@Entity(name = "t_sys_relation")
@Table(appliesTo = "t_sys_relation", comment = "菜单角色关系")
@Data
public class Relation {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private Long menuid;
  @Column
  private Long roleid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMenuid() {
    return menuid;
  }

  public void setMenuid(Long id) {

  }

  public Long getRoleid() {
    return roleid;
  }

  public void setRoleid(Long roleId) {

  }
}
