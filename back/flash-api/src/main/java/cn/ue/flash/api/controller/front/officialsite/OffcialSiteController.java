package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.enumeration.cms.ChannelEnum;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.offcialsite.BannerVo;
import cn.ue.flash.bean.vo.offcialsite.News;
import cn.ue.flash.bean.vo.offcialsite.Product;
import cn.ue.flash.bean.vo.offcialsite.Solution;
import cn.ue.flash.service.cms.ArticleService;
import cn.ue.flash.service.cms.BannerService;
import cn.ue.flash.utils.Maps;
import cn.ue.flash.utils.factory.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:29
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@RestController
@RequestMapping("/offcialsite")
public class OffcialSiteController extends BaseController {

  @Autowired
  private BannerService bannerService;
  @Autowired
  private ArticleService articleService;

  @RequestMapping(method = RequestMethod.GET)
  public Object index() {
    Map<String, Object> dataMap = Maps.newHashMap();

    BannerVo banner = bannerService.queryIndexBanner();
    dataMap.put("banner", banner);
    List<News> newsList = new ArrayList<>();
    List<Article> articles = articleService.queryIndexNews();
    for (Article article : articles) {
      News news = new News();
      news.setDesc(article.getTitle());
      news.setUrl("/article?id=" + article.getId());
      news.setSrc("static/images/icon/user.png");
      newsList.add(news);
    }
    dataMap.put("newsList", newsList);

    List<Product> products = new ArrayList<>();
    Page<Article> articlePage = articleService.query(1, 4, ChannelEnum.PRODUCT.getId());
    for (Article article : articlePage.getRecords()) {
      Product product = new Product();
      product.setId(article.getId());
      product.setName(article.getTitle());
      product.setImg(article.getImg());
      products.add(product);
    }
    dataMap.put("productList", products);

    List<Solution> solutions = new ArrayList<>();
    articlePage = articleService.query(1, 4, ChannelEnum.SOLUTION.getId());
    for (Article article : articlePage.getRecords()) {
      Solution solution = new Solution();
      solution.setId(article.getId());
      solution.setName(article.getTitle());
      solution.setImg(article.getImg());
      solutions.add(solution);
    }
    dataMap.put("solutionList", solutions);
    Map map = Maps.newHashMap("data", dataMap);
    return Rets.success(map);

  }
}
