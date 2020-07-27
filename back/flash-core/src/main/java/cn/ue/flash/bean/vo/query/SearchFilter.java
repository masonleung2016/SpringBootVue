package cn.ue.flash.bean.vo.query;

import cn.ue.flash.utils.Maps;
import cn.ue.flash.utils.StringUtil;

import java.util.Map;

/**
 * @Description: 查询条件封装类
 * @Author: LCF
 * @Date: 2020/7/20 14:33
 * @Package: cn.ue.flash.bean.vo.query
 * @Version 1.0
 */

public class SearchFilter {
  public Join join = Join.and;
  public String fieldName;
  public Object value;
  public Operator operator;

  public SearchFilter(String fieldName, Operator operator) {
    this.fieldName = fieldName;
    this.operator = operator;

  }

  public SearchFilter(String fieldName, Operator operator, Object value) {
    if (!StringUtil.isNullOrEmpty(value)) {
      this.fieldName = fieldName;
      this.value = value;
      this.operator = operator;
    }
  }

  public SearchFilter(String fieldName, Operator operator, Object value, Join join) {
    if (!StringUtil.isNullOrEmpty(value)) {
      this.fieldName = fieldName;
      this.value = value;
      this.operator = operator;
      this.join = join;
    }
  }

  public static SearchFilter build(String fieldName, Object value) {
    return new SearchFilter(fieldName, Operator.EQ, value);
  }

  public static SearchFilter build(String fieldName, Operator operator) {
    return new SearchFilter(fieldName, operator);
  }

  public static SearchFilter build(String fieldName, Operator operator, Object value) {
    return new SearchFilter(fieldName, operator, value);
  }

  public static SearchFilter build(String fieldName, Object value, Join join) {
    return new SearchFilter(fieldName, Operator.EQ, value, join);

  }

  /**
   * searchParams中key的格式为OPERATOR_FIELDNAME
   */
  public static Map<String, SearchFilter> parse(Map<String, Object> searchParams) {
    Map<String, SearchFilter> filters = Maps.newHashMap();

    for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
      /** 过滤掉空值 */
      String key = entry.getKey();
      Object value = entry.getValue();
      /**if (StringUtil.isBlank((String) value)) {
       continue;
       }*/

      /** 拆分operator与filedAttribute*/
      String[] names = StringUtil.split(key, "_");
      if (names.length != 2) {
        throw new IllegalArgumentException(key + " is not a valid search filter name");
      }
      String filedName = names[1];
      Operator operator = Operator.valueOf(names[0]);

      /** 创建searchFilter */
      SearchFilter filter = new SearchFilter(filedName, operator, value);
      filters.put(key, filter);
    }

    return filters;
  }

  public enum Operator {
    BETWEEN, EQ, GT, GTE, IN, ISNOTNULL, ISNULL, LIKE, LIKEL, LIKER, LT, LTE, NE, NOTIN

  }

  public enum Join {
    and, or
  }
}