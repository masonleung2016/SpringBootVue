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
    /**主键ID*/
    private String account;
    /**账号*/
    private String password;
    private String name;
    /**姓名*/
    private Long deptId;
    /**部门id*/
    private List<Long> roleList;
    /**角色集*/
    private String deptName;
    /**部门名称*/
    private List<String> roleNames;
    /**角色名称集*/
    private List<String> roleCodes;
    /**角色编码*/
    private Set<String> urls;
    /**资源路径*/
    private Set<String> permissions;

    public Collection<String> getRoleCodes() {
        return null;
    }

    public String getUrls() {
        return null;
    }

    public String getDeptName() {
        return null;
    }

    public Object getRoleNames() {
        return null;
    }

    public List<Long> getRoleList() {
        return null;
    }

    public Set<String> getPermissions() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public void setId(Long valueOf) {

    }

    public void setAccount(String account) {

    }

    public void setDeptId(Long deptid) {

    }

    public void setDeptName(String deptName) {

    }

    public void setName(Object name) {

    }

    public void setPassword(byte[] password) {

    }

    public void setRoleList(List<Long> roleList) {

    }

    public void setRoleNames(List<String> roleNameList) {

    }

    public void setRoleCodes(List<String> roleCodeList) {

    }

    public void setPermissions(Set<String> permissions) {

    }

    public void setUrls(Set<String> resUrls) {

    }
    /**资源编码*/

}
