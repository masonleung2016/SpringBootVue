package cn.ue.flash.api;

import cn.ue.flash.dao.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:44
 * @Package: cn.ue.flash.api
 * @Version 1.0
 */

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = "cn.ue.flash")
@EntityScan(basePackages = "cn.ue.flash.bean.entity")
@EnableJpaRepositories(basePackages = "cn.ue.flash.dao", repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@EnableJpaAuditing
public class ApiApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ApiApplication.class);
  }
}
