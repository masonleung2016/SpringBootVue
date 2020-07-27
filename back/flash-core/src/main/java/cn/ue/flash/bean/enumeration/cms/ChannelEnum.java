package cn.ue.flash.bean.enumeration.cms;

/**
 * @Description: 频道类型
 * @Author: LCF
 * @Date: 2020/7/20 14:10
 * @Package: cn.ue.flash.bean.enumeration.cms
 * @Version 1.0
 */

public enum ChannelEnum {

  CASE(4L, "case"),
  NEWS(1L, "news"),
  PRODUCT(2L, "product"),
  SOLUTION(3L, "solution");


  private String value;
  private Long id;

  ChannelEnum(Long id, String value) {
    this.id = id;
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
