package cn.ue.flash.service.cms;

import cn.ue.flash.bean.entity.cms.Contacts;
import cn.ue.flash.dao.cms.ContactsRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:03
 * @Package: cn.ue.flash.service.cms
 * @Version 1.0
 */

@Service
public class ContactsService extends BaseService<Contacts, Long, ContactsRepository> {
}
