package cn.ue.flash.dao.message;

import cn.ue.flash.bean.entity.message.MessageTemplate;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:49
 * @Package: cn.ue.flash.dao.message
 * @Version 1.0
 */

public interface MessagetemplateRepository extends BaseRepository<MessageTemplate, Long> {
    MessageTemplate findByCode(String code);

    List<MessageTemplate> findByIdMessageSender(Long idMessageSender);
}
