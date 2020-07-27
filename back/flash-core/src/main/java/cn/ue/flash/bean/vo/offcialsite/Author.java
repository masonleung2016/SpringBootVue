package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:30
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class Author {
  private String name;
  private String avatar;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
