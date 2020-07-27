package cn.ue.flash.cache;

import java.io.Serializable;

/**
 * @Description: 缓存接口
 * @Author: LCF
 * @Date: 2020/7/20 14:40
 * @Package: cn.ue.flash.cache
 * @Version 1.0
 */

public interface CacheDao {
  String CONSTANT = "CONSTANT";
  String SESSION = "SESSION";

  /**
   * 设置hash key值
   *
   * @param key
   * @param k
   * @param val
   */
  void hset(Serializable key, Serializable k, Object val);

  /**
   * 获取hash key值
   *
   * @param key
   * @param k
   * @return
   */
  Serializable hget(Serializable key, Serializable k);

  /**
   * 获取hash key值
   *
   * @param key
   * @param k
   * @param klass
   * @param <T>
   * @return
   */
  <T> T hget(Serializable key, Serializable k, Class<T> klass);

  /**
   * 设置key值，超时失效
   *
   * @param key
   * @param val
   */
  void set(Serializable key, Object val);


  /**
   * 获取key值
   *
   * @param key
   * @param klass
   * @return
   */
  <T> T get(Serializable key, Class<T> klass);

  String get(Serializable key);


  void del(Serializable key);

  void hdel(Serializable key, Serializable k);
}
