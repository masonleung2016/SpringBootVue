package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.LoginLog;
import cn.ue.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:51
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface LoginLogRepository extends BaseRepository<LoginLog, Long> {
  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "delete from t_sys_login_log")
  int clear();
}
