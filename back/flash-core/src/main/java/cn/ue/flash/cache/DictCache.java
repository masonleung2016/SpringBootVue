package cn.ue.flash.cache;

import cn.ue.flash.bean.entity.system.Dict;

import java.util.List;

/**
 * @Description: 字典缓存
 * @Author: LCF
 * @Date: 2020/7/20 14:41
 * @Package: cn.ue.flash.cache
 * @Version 1.0
 */

public interface DictCache extends Cache {

  List<Dict> getDictsByPname(String dictName);

  String getDict(Long dictId);
}
