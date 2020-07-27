package cn.ue.flash.service.message.sms.tencent;

import cn.ue.flash.bean.enumeration.ConfigKeyEnum;
import cn.ue.flash.cache.ConfigCache;
import cn.ue.flash.service.message.sms.SmsSender;
import cn.ue.flash.utils.StringUtil;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:04
 * @Package: cn.ue.flash.service.message.sms.tencent
 * @Version 1.0
 */

@Service
public class TencentSmsSender implements SmsSender {
  private Logger logger = LoggerFactory.getLogger(TencentSmsSender.class);
  @Autowired
  private ConfigCache configCache;

  @Override
  public boolean sendSms(String tplCode, String receiver, String[] args, String content) {
    Integer appid = Integer.valueOf((String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_APPID.getValue()));
    String appkey = (String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_APPKEY.getValue());
    String smsSign = (String) configCache.get(ConfigKeyEnum.API_TENCENT_SMS_SIGN.getValue());
    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
    SmsSingleSenderResult result = null;
    try {
      if (StringUtil.isNotEmpty(tplCode)) {
        /**根据指定模板id发送短信*/
        /** 签名参数未提供或者为空时，会使用默认签名发送短信*/
        result = ssender.sendWithParam("86", receiver,
            Integer.valueOf(tplCode), args, smsSign, "", "");
      } else {
        /**发送固定内容短信*/
        result = ssender.send(0, "86", receiver,
            content, "", "");

      }
      logger.info(result.errMsg);
      return result.result == 0;
    } catch (Exception e) {
      logger.error("发送短信异常", e);
    }

    return false;
  }

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public ConfigCache getConfigCache() {
    return configCache;
  }

  public void setConfigCache(ConfigCache configCache) {
    this.configCache = configCache;
  }
}