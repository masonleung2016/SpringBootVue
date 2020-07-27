package cn.ue.flash.bean.core;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Description: 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @Author: LCF
 * @Date: 2020/7/20 13:54
 * @Package: cn.ue.flash.bean.core
 * @Version 1.0
 */

@Data
public class ShiroUser implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  /**
   * 主键ID
   */
  private String account;
  /**
   * 账号
   */
  private String password;
  private String name;
  /**
   * 姓名
   */
  private Long deptId;
  /**
   * 部门id
   */
  private List<Long> roleList;
  /**
   * 角色集
   */
  private String deptName;
  /**
   * 部门名称
   */
  private List<String> roleNames;
  /**
   * 角色名称集
   */
  private List<String> roleCodes;
  /**
   * 角色编码
   */
  private Set<String> urls;
  /**
   * 资源路径
   */
  private Set<String> permissions;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Collection<String> getRoleCodes() {
    return null;
  }

  public void setRoleCodes(List<String> roleCodeList) {

  }

  public String getUrls() {
    return null;
  }

  public void setUrls(Set<String> resUrls) {

  }

  public String getDeptName() {
    return null;
  }

  public void setDeptName(String deptName) {

  }

  public Object getRoleNames() {
    return null;
  }

  public void setRoleNames(List<String> roleNameList) {

  }

  public List<Long> getRoleList() {
    return null;
  }

  public void setRoleList(List<Long> roleList) {

  }

  public Set<String> getPermissions() {
    return null;
  }

  public void setPermissions(Set<String> permissions) {

  }

  public String getPassword() {
    return null;
  }

  public void setPassword(byte[] password) {

  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long valueOf) {

  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setName(Object name) {

  }

  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptid) {

  }
  /**资源编码*/

}