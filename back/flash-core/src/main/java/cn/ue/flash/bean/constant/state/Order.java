package cn.ue.flash.bean.constant.state;

/**
 * @Description: 数据库排序
 * @Author: LCF
 * @Date: 2020/7/20 13:51
 * @Package: cn.ue.flash.bean.constant.state
 * @Version 1.0
 */

public enum Order {

  ASC("asc"), DESC("desc");

  private String des;

  Order(String des) {
    this.des = des;
  }

  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }
}
