package cn.ue.flash.service.test;

import cn.ue.flash.bean.entity.test.Boy;
import cn.ue.flash.dao.test.BoyRepository;

import cn.ue.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:25
 * @Package: cn.ue.flash.service.test
 * @Version 1.0
 */

@Service
public class BoyService extends BaseService<Boy, Long, BoyRepository> {
  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private BoyRepository boyRepository;

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public BoyRepository getBoyRepository() {
    return boyRepository;
  }

  public void setBoyRepository(BoyRepository boyRepository) {
    this.boyRepository = boyRepository;
  }
}
