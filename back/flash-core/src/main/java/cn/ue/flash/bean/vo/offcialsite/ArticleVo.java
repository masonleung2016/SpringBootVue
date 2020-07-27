package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:30
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class ArticleVo {
  private String id;
  private String title;
  private String content;
  private Author author;
  private Date createAt;
  private List<Reply> replies;

  public ArticleVo() {
  }

  public ArticleVo(String id, String title, String content, Author author, Date createAt) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
    this.createAt = createAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public List<Reply> getReplies() {
    return replies;
  }

  public void setReplies(List<Reply> replies) {
    this.replies = replies;
  }
}
