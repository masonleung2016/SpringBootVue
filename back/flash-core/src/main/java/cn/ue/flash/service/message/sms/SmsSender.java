package cn.ue.flash.service.message.sms;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:05
 * @Package: cn.ue.flash.service.message
 * @Version 1.0
 */

public interface SmsSender {
  /**
   * 发送短信，如果内容content不为空，则直接发送内容
   *
   * @param tplCode  短信运营商模板号码
   * @param receiver
   * @param args
   * @param content
   * @return
   */
  boolean sendSms(String tplCode, String receiver, String[] args, String content);
}
