package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.enumeration.cms.BannerTypeEnum;
import cn.ue.flash.bean.enumeration.cms.ChannelEnum;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.offcialsite.BannerVo;
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
 * @Date: 2020/7/20 13:30
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@RestController
@RequestMapping("/offcialsite/solution")
public class SolutionController extends BaseController {
  @Autowired
  private BannerService bannerService;
  @Autowired
  private ArticleService articleService;

  @RequestMapping(method = RequestMethod.GET)
  public Object index() {
    Map<String, Object> dataMap = Maps.newHashMap();

    BannerVo banner = bannerService.queryBanner(BannerTypeEnum.SOLUTION.getValue());
    dataMap.put("banner", banner);

    List<Solution> solutions = new ArrayList<>();
    Page<Article> articlePage = articleService.query(1, 10, ChannelEnum.SOLUTION.getId());
    for (Article article : articlePage.getRecords()) {
      solutions.add(new Solution(article.getId(), article.getTitle(), article.getImg()));
    }
    dataMap.put("solutionList", solutions);

    Map map = Maps.newHashMap("data", dataMap);
    return Rets.success(map);

  }
}
