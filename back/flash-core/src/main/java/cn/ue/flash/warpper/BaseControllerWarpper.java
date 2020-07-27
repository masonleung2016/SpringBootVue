package cn.ue.flash.warpper;

import java.util.List;
import java.util.Map;

/**
 * @Description: 控制器查询结果的包装类基类
 * @Author: LCF
 * @Date: 2020/7/20 15:52
 * @Package: cn.ue.flash.warpper
 * @Version 1.0
 */

public abstract class BaseControllerWarpper {

  public Object obj = null;

  public BaseControllerWarpper(Object obj) {
    this.obj = obj;
  }

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }

  @SuppressWarnings("unchecked")
  public Object warp() {

    if (this.obj instanceof List) {
      List<Map<String, Object>> list = (List<Map<String, Object>>) this.obj;
      for (Map<String, Object> map : list) {
        warpTheMap(map);
      }
      return list;
    } else if (this.obj instanceof Map) {
      Map<String, Object> map = (Map<String, Object>) this.obj;
      warpTheMap(map);
      return map;
    } else {
      return this.obj;
    }
  }

  /**
   * 数据转换
   *
   * @param map
   */
  protected abstract void warpTheMap(Map<String, Object> map);
}
