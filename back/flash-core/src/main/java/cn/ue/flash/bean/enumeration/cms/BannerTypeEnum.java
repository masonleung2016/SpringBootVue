package cn.ue.flash.bean.enumeration.cms;

/**
 * @Description: 广告类型
 * @Author: LCF
 * @Date: 2020/7/20 14:09
 * @Package: cn.ue.flash.bean.enumeration.cms
 * @Version 1.0
 */

public enum BannerTypeEnum {

  CASE("case"),
  INDEX("index"),
  NEWS("news"),
  PRODUCT("product"),
  SOLUTION("solution");

  private String value;

  BannerTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
