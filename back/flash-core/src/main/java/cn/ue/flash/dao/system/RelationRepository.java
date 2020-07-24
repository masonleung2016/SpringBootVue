package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Relation;
import cn.ue.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:52
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface RelationRepository extends BaseRepository<Relation, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from t_sys_relation where roleid=?1")
    int deleteByRoleId(Long roleId);
}
