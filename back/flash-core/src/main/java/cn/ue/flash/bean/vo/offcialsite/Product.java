package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:32
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class Product {
  private Long id;
  private String name;
  private String img;

  public Product() {

  }

  public Product(Long id, String name, String img) {
    this.id = id;
    this.name = name;
    this.img = img;
  }

  public Product(Long id, Object title, Object img) {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {

  }

  public String getName() {
    return name;
  }

  public void setName(Object title) {

  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImg() {
    return img;
  }

  public void setImg(Object img) {

  }

  public void setImg(String img) {
    this.img = img;
  }
}
