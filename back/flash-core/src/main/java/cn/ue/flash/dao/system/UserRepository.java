package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.User;
import cn.ue.flash.dao.BaseRepository;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:54
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface UserRepository extends BaseRepository<User, Long> {
  User findByAccount(String account);

  User findByAccountAndStatusNot(String account, Integer status);
}
