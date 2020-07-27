package cn.ue.flash.dao.system;

import cn.ue.flash.bean.entity.system.Task;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:53
 * @Package: cn.ue.flash.dao.system
 * @Version 1.0
 */

public interface TaskRepository extends BaseRepository<Task, Long> {

  long countByNameLike(String name);

  List<Task> findByNameLike(String name);

  List<Task> findAllByDisabled(boolean disable);
}

