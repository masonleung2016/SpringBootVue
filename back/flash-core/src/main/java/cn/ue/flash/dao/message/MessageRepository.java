package cn.ue.flash.dao.message;

import cn.ue.flash.bean.entity.message.Message;
import cn.ue.flash.dao.BaseRepository;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:48
 * @Package: cn.ue.flash.dao.message
 * @Version 1.0
 */

public interface MessageRepository extends BaseRepository<Message, Long> {
  void deleteAllByIdIn(ArrayList<String> list);
}
