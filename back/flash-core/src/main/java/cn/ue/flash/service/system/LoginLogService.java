package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.LoginLog;
import cn.ue.flash.dao.system.LoginLogRepository;
import cn.ue.flash.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:14
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

@Service
public class LoginLogService extends BaseService<LoginLog, Long, LoginLogRepository> {

}
