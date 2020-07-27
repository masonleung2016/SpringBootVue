package cn.ue.flash.cache.impl;

import cn.ue.flash.bean.constant.cache.CacheKey;
import cn.ue.flash.bean.entity.system.Dict;
import cn.ue.flash.cache.BaseCache;
import cn.ue.flash.cache.CacheDao;
import cn.ue.flash.cache.DictCache;
import cn.ue.flash.dao.system.DictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:37
 * @Package: cn.ue.flash.cache.impl
 * @Version 1.0
 */

@Component
public class DictCacheImpl extends BaseCache implements DictCache {
  @Autowired
  private DictRepository dictRepository;
  @Autowired
  private CacheDao cacheDao;

  @Override
  public List<Dict> getDictsByPname(String dictName) {
    return (List<Dict>) cacheDao.hget(CacheDao.CONSTANT, CacheKey.DICT + dictName, List.class);
  }

  @Override
  public String getDict(Long dictId) {
    return (String) get(CacheKey.DICT_NAME + dictId);
  }

  @Override
  public void cache() {
    super.cache();
    List<Dict> list = dictRepository.findByPid(0L);
    for (Dict dict : list) {
      List<Dict> children = dictRepository.findByPid(dict.getId());
      if (children.isEmpty()) {
        continue;
      }
      set(String.valueOf(dict.getId()), children);
      set((String) dict.getName(), children);
      for (Dict child : children) {
        set(CacheKey.DICT_NAME + child.getId(), child.getName());
      }

    }

  }

  @Override
  public Object get(String key) {
    return cacheDao.hget(CacheDao.CONSTANT, CacheKey.DICT + key);
  }

  @Override
  public void set(String key, Object val) {
    cacheDao.hset(CacheDao.CONSTANT, CacheKey.DICT + key, val);

  }

  public DictRepository getDictRepository() {
    return dictRepository;
  }

  public void setDictRepository(DictRepository dictRepository) {
    this.dictRepository = dictRepository;
  }

  public CacheDao getCacheDao() {
    return cacheDao;
  }

  public void setCacheDao(CacheDao cacheDao) {
    this.cacheDao = cacheDao;
  }
}