package cn.ue.flash.service.cms;

import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.enumeration.cms.ChannelEnum;
import cn.ue.flash.bean.vo.query.SearchFilter;
import cn.ue.flash.dao.cms.ArticleRepository;
import cn.ue.flash.service.BaseService;
import cn.ue.flash.utils.factory.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:01
 * @Package: cn.ue.flash.service.cms
 * @Version 1.0
 */

@Service
public class ArticleService extends BaseService<Article, Long, ArticleRepository> {
  @Autowired
  private ArticleRepository articleRepository;

  /**
   * 查询首页最近5条资讯数据
   *
   * @return
   */
  public List<Article> queryIndexNews() {
    Page<Article> page = query(1, 5, ChannelEnum.NEWS.getId());
    return page.getRecords();
  }

  public Page<Article> query(int currentPage, int size, Long idChannel) {
    Page page = new Page(currentPage, size, "id");
    page.addFilter(SearchFilter.build("idChannel", SearchFilter.Operator.EQ, idChannel));
    return queryPage(page);
  }

  public ArticleRepository getArticleRepository() {
    return articleRepository;
  }

  public void setArticleRepository(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }
}
