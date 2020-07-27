package cn.ue.flash.dao;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQLStorageEngine;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:57
 * @Package: cn.ue.flash.dao
 * @Version 1.0
 */

public class MySQLDialect extends MySQL5Dialect {
  @Override
  protected MySQLStorageEngine getDefaultMySQLStorageEngine() {
    return InnoDBStorageEngine.INSTANCE;
  }
}
