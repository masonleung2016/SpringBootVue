package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.enumeration.cms.BannerTypeEnum;
import cn.ue.flash.bean.enumeration.cms.ChannelEnum;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.bean.vo.offcialsite.BannerVo;
import cn.ue.flash.bean.vo.offcialsite.Product;
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
 * @Date: 2020/7/20 13:27
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@RestController
@RequestMapping("/offcialsite/case")
public class CaseController extends BaseController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        Map<String, Object> dataMap = new HashMap<>(2);

        BannerVo banner = bannerService.queryBanner(BannerTypeEnum.CASE.getValue());
        dataMap.put("banner", banner);

        List<Product> products = new ArrayList<>();
        Page<Article> articlePage = articleService.query(1, 10, ChannelEnum.PRODUCT.getId());
        for (Article article : articlePage.getRecords()) {
            products.add(new Product(article.getId(), article.getTitle(), article.getImg()));
        }
        dataMap.put("caseList", products);


        Map map = new HashMap(1);

        map.put("data", dataMap);
        return Rets.success(map);

    }
}
