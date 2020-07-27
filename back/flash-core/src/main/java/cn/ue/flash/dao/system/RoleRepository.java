package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Role;
import cn.ue.flash.dao.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:52
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface RoleRepository extends BaseRepository<Role, Long> {
  @Query(nativeQuery = true, value = "SELECT id, pId, NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) OPEN FROM t_sys_role")
  List roleTreeList();

  @Query(nativeQuery = true, value = "SELECT r.id AS id, pId AS pId, NAME AS NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) \"open\", ( CASE WHEN (r1.ID = 0 OR r1.ID IS NULL) THEN 'false' ELSE 'true' END ) AS checked FROM t_sys_role r LEFT JOIN ( SELECT ID FROM t_sys_role WHERE ID IN (?1)) r1 ON r.ID = r1.ID ORDER BY pId, num ASC")
  List roleTreeListByRoleId(Long[] ids);

  List findByName(String roleName);
}
