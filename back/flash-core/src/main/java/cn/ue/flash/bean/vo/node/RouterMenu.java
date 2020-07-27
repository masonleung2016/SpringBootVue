package cn.ue.flash.bean.vo.node;

import cn.ue.flash.utils.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:27
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

@Data
public class RouterMenu {
  private Long id;
  private Long parentId;
  private String path;
  private String component;
  private String name;
  private Integer num;
  private Boolean hidden = false;
  private MenuMeta meta;
  private List<RouterMenu> children = Lists.newArrayList();

  public List<RouterMenu> getChildren() {
    return children;
  }

  public void setChildren(List<RouterMenu> children) {
    this.children = children;
  }

  public Number getParentId() {
    return null;
  }

  public void setParentId(Long valueOf) {

  }

  public int getNum() {
    return 0;
  }

  public void setNum(Integer valueOf) {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long valueOf) {

  }

  public String getPath() {
    return path;
  }

  public void setPath(String valueOf) {

  }

  public String getComponent() {
    return component;
  }

  public void setComponent(String toString) {

  }

  public String getName() {
    return name;
  }

  public void setName(String valueOf) {

  }

  public Boolean getHidden() {
    return hidden;
  }

  public void setHidden(boolean b) {

  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public MenuMeta getMeta() {
    return meta;
  }

  public void setMeta(MenuMeta meta) {

  }
}
