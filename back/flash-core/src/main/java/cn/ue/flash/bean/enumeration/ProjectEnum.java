package cn.ue.flash.bean.enumeration;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:14
 * @Package: cn.ue.flash.bean.enumeration
 * @Version 1.0
 */

public enum ProjectEnum {

  DOLPHIN_PROD("dolphin"),
  SCORE_CARD("ScoreCard"),
  SNOW_PRODUCT("PRJ_SNOW_PRODUCT");

  private String value;

  ProjectEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}