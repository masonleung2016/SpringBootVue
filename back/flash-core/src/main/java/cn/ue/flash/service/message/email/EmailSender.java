package cn.ue.flash.service.message.email;

import org.springframework.core.io.InputStreamSource;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:04
 * @Package: cn.ue.flash.service.message.email
 * @Version 1.0
 */

public interface EmailSender {
  /**
   * 发送邮件
   *
   * @param from
   * @param to
   * @param cc
   * @param title
   * @param content
   * @return
   */
  boolean sendEmail(String from, String to, String cc, String title, String content);

  /**
   * 发送带附件的邮件
   *
   * @param from
   * @param to
   * @param cc
   * @param title
   * @param content
   * @param attachmentFilename
   * @param inputStreamSource
   * @return
   */
  boolean sendEmail(String from, String to, String cc, String title, String content, String attachmentFilename, InputStreamSource inputStreamSource);
}
