package cn.ue.flash.bean.vo.node;

import cn.ue.flash.utils.StringUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:26
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

@Data
public class Node {
  private Long id;
  private Long pid;
  private String name;
  private Boolean checked;
  private List<Node> children = new ArrayList<>(10);

  public Number getPid() {
    return null;
  }

  public void setPid(Long getpId) {

  }

  public Number getId() {
    return null;
  }

  public void setId(Long id) {

  }

  public StringUtil getChildren() {
    return null;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {

  }

  public Boolean getChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {

  }
}
