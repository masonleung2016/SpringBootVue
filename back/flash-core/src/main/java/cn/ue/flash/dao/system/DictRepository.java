package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Dict;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:50
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface DictRepository extends BaseRepository<Dict, Long> {
  List<Dict> findByPid(Long pid);

  List<Dict> findByNameAndPid(String name, Long pid);

  List<Dict> findByNameLike(String name);
}
