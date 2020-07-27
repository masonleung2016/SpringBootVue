package cn.ue.flash.bean.vo.query;

import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

/**
 * @Description: 将SearchFilter查询条件解析为jpa查询对象Predicate
 * @Author: LCF
 * @Date: 2020/7/20 14:33
 * @Package: cn.ue.flash.bean.vo.query
 * @Version 1.0
 */

public class DynamicSpecifications {
  public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> filters, final Class<T> entityClazz) {
    SimpleSpecification<T> simpleSpecification = new SimpleSpecification<T>(filters);
    return simpleSpecification;
  }
}