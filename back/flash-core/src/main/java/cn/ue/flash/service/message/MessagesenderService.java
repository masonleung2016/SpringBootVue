package cn.ue.flash.service.message;

import cn.ue.flash.bean.entity.message.MessageSender;
import cn.ue.flash.bean.entity.message.MessageTemplate;
import cn.ue.flash.dao.message.MessagesenderRepository;
import cn.ue.flash.dao.message.MessagetemplateRepository;
import cn.ue.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:07
 * @Package: cn.ue.flash.service.message
 * @Version 1.0
 */

@Service
public class MessagesenderService extends BaseService<MessageSender, Long, MessagesenderRepository> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MessagesenderRepository messageSenderRepository;
    @Autowired
    private MessagetemplateRepository messagetemplateRepository;

    public void save(MessageSender messageSender) {
        messageSenderRepository.save(messageSender);
    }

    @Override
    public void delete(Long id) {
        List<MessageTemplate> templateList = messagetemplateRepository.findByIdMessageSender(id);
        if (templateList.isEmpty()) {
            messageSenderRepository.deleteById(id);
        } else {
            throw new RuntimeException("有模板使用该发送器，无法删除");
        }
    }

}
