package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.OperationLog;
import cn.ue.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:52
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface OperationLogRepository extends BaseRepository<OperationLog, Long> {
  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "delete from t_sys_operation_log")
  int clear();
}
