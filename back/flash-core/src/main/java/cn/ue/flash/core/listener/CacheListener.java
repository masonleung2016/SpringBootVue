package cn.ue.flash.core.listener;

import cn.ue.flash.cache.ConfigCache;
import cn.ue.flash.cache.DictCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Description: 系统监听器
 * 系统启动时加载全局参数(t_sys_cfg标中的数据)到缓存中
 * @Author: LCF
 * @Date: 2020/7/20 14:43
 * @Package: cn.ue.flash.core.listener
 * @Version 1.0
 */

@Component
public class CacheListener implements CommandLineRunner {

  @Autowired
  private ConfigCache configCache;
  @Autowired
  private DictCache dictCache;
  private Logger logger = LoggerFactory.getLogger(CacheListener.class);

  public void loadCache() {
    configCache.cache();
    dictCache.cache();
  }

  public ConfigCache getConfigCache() {
    return configCache;
  }

  public void setConfigCache(ConfigCache configCache) {
    this.configCache = configCache;
  }

  public DictCache getDictCache() {
    return dictCache;
  }

  public void setDictCache(DictCache dictCache) {
    this.dictCache = dictCache;
  }

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  @Override
  public void run(String... strings) throws Exception {
    logger.info(".....................load cache........................");

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        loadCache();
      }
    });
    thread.start();
  }
}
