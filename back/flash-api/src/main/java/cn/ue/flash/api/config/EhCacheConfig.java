package cn.ue.flash.api.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description: 加载ehcache缓存配置
 * @Author: LCF
 * @Date: 2020/7/20 13:20
 * @Package: cn.ue.flash.api.config
 * @Version 1.0
 */

@Configuration
@EnableCaching
public class EhCacheConfig {

  @Bean
  public EhCacheCacheManager cacheManager(CacheManager cacheManager) {
    return new EhCacheCacheManager(cacheManager);
  }

  @Bean
  public EhCacheManagerFactoryBean ehcache() {
    EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    return ehCacheManagerFactoryBean;
  }
}
