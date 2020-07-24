package cn.ue.flash.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:56
 * @Package: cn.ue.flash.dao
 * @Version 1.0
 */

@Configuration
@EnableJpaRepositories("cn.ue.flash.dao")
public class DaoConfiguration {
}
