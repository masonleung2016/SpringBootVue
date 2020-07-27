package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.enumeration.cms.BannerTypeEnum;
import cn.ue.flash.bean.enumeration.cms.ChannelEnum;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.offcialsite.BannerVo;
import cn.ue.flash.bean.vo.offcialsite.News;
import cn.ue.flash.service.cms.ArticleService;
import cn.ue.flash.service.cms.BannerService;
import cn.ue.flash.utils.factory.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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
@RequestMapping("/offcialsite/news")
public class NewsController extends BaseController {
  @Autowired
  private BannerService bannerService;
  @Autowired
  private ArticleService articleService;

  @RequestMapping(method = RequestMethod.GET)
  public Object list() {
    Map<String, Object> dataMap = new HashMap<>(10);
    BannerVo banner = bannerService.queryBanner(BannerTypeEnum.NEWS.getValue());
    dataMap.put("banner", banner);

    List<News> newsList = new ArrayList<>();
    Page<Article> articlePage = articleService.query(1, 10, ChannelEnum.NEWS.getId());

    for (Article article : articlePage.getRecords()) {
      News news = new News();
      news.setDesc(article.getTitle());
      news.setUrl("/article?id=" + article.getId());
      news.setSrc("static/images/icon/user.png");
      newsList.add(news);
    }

    dataMap.put("list", newsList);

    Map map = new HashMap(2);

    map.put("data", dataMap);
    return Rets.success(map);

  }
}
