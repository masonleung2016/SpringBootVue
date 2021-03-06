package cn.ue.flash.dao;

import cn.ue.flash.utils.Lists;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.nutz.mapl.Mapl;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: 基础dao实现类
 * @Author: LCF
 * @Date: 2020/7/20 14:56
 * @Package: cn.ue.flash.dao
 * @Version 1.0
 */

public class BaseRepositoryImpl<T, ID extends Serializable>
    extends SimpleJpaRepository<T, ID>
    implements BaseRepository<T, ID> {
  private final EntityManager entityManager;
  private Class<T> klass;


  BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation,
                     EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
    this.klass = (Class<T>) entityInformation.getJavaType();
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public Class<T> getKlass() {
    return klass;
  }

  public void setKlass(Class<T> klass) {
    this.klass = klass;
  }

  @Override
  public List<T> queryBySql(String sql, Class<T> klass) {
    return (List<T>) queryObjBySql(sql, klass);
  }

  @Override
  public List<?> queryObjBySql(String sql, Class<?> klass) {
    List<Map> list = queryBySql(sql);
    if (list.isEmpty()) {
      return null;
    }
    List result = Lists.newArrayList();
    for (Map map : list) {
      try {
        Object bean = Mapl.maplistToObj(map, klass);
        result.add(bean);
      } catch (Exception e) {
      }
    }
    return result;
  }

  @Override
  public List<Map> queryBySql(String sql) {
    Query query = entityManager.createNativeQuery(sql);
    query.unwrap(NativeQueryImpl.class)
        .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    List list = query.getResultList();
    return list;
  }

  @Override
  public Map getMapBySql(String sql) {
    List<Map> list = queryBySql(sql);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public T getBySql(String sql) {
    List<T> list = queryBySql(sql, klass);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public T getOne(ID id) {
    return findById(id).get();
  }

  @Override
  public T get(String sql) {
    List<T> list = entityManager.createNativeQuery(sql, klass).getResultList();
    return list.get(0);
  }

  @Override
  public int execute(String sql) {
    return entityManager.createNativeQuery(sql).executeUpdate();
  }

  @Override
  public Class<T> getDataClass() {
    return klass;
  }

  @Override
  public List<T> query(String sql) {
    return entityManager.createNativeQuery(sql, klass).getResultList();
  }
}
