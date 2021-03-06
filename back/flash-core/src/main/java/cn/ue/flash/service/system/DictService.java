package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.Dict;
import cn.ue.flash.cache.DictCache;
import cn.ue.flash.dao.system.DictRepository;
import cn.ue.flash.service.BaseService;
import cn.ue.flash.utils.factory.MutiStrFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description: 字典服务
 * @Author: LCF
 * @Date: 2020/7/20 15:11
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

@Service
public class DictService extends BaseService<Dict, Long, DictRepository> {
  @Resource
  DictRepository dictRepository;
  private Logger logger = LoggerFactory.getLogger(DictService.class);
  @Autowired
  private DictCache dictCache;

  public void addDict(String dictName, String dictValues) {
    /**判断有没有该字典*/
    List<Dict> dicts = dictRepository.findByNameAndPid(dictName, 0L);
    if (dicts != null && dicts.size() > 0) {
      return;
    }

    /**解析dictValues*/
    List<Map<String, String>> items = MutiStrFactory.parseKeyValue(dictValues);

    /**添加字典*/
    Dict dict = new Dict();
    dict.setName(dictName);
    dict.setNum("0");
    dict.setPid(0L);
    this.dictRepository.save(dict);

    /**添加字典条目*/
    for (Map<String, String> item : items) {
      String num = item.get(MutiStrFactory.MUTI_STR_KEY);
      String name = item.get(MutiStrFactory.MUTI_STR_VALUE);
      Dict itemDict = new Dict();
      itemDict.setPid(dict.getId());
      itemDict.setName(name);
      try {
        itemDict.setNum(num);
      } catch (NumberFormatException e) {
        logger.error(e.getMessage(), e);
      }
      this.dictRepository.save(itemDict);
    }
    dictCache.cache();
  }

  public void editDict(Long dictId, String dictName, String dicts) {
    /**删除之前的字典*/
    this.delteDict(dictId);

    /**重新添加新的字典*/
    this.addDict(dictName, dicts);

    dictCache.cache();
  }

  public void delteDict(Long dictId) {
    /**删除这个字典的子词典*/
    List<Dict> subList = dictRepository.findByPid(dictId);
    dictRepository.deleteAll(subList);
    /**删除这个词典*/
    dictRepository.deleteById(dictId);

    dictCache.cache();
  }

  @Override
  public Dict get(Long id) {
    Optional<Dict> optional = dictRepository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  public List<Dict> findByNameLike(String name) {
    return dictRepository.findByNameLike(name);
  }

  public List<Dict> findByPid(Long pid) {
    return dictRepository.findByPid(pid);
  }

  public DictRepository getDictRepository() {
    return dictRepository;
  }

  public void setDictRepository(DictRepository dictRepository) {
    this.dictRepository = dictRepository;
  }

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public DictCache getDictCache() {
    return dictCache;
  }

  public void setDictCache(DictCache dictCache) {
    this.dictCache = dictCache;
  }
}

