package cn.ue.flash.api.controller.front.officialsite;

import cn.ue.flash.api.controller.BaseController;
import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.service.cms.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 13:27
 * @Package: cn.ue.flash.api.controller.front.officialsite
 * @Version 1.0
 */

@RestController
@RequestMapping("/offcialsite/article")
public class ArticleController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Object get(@Param("id") Long id, @Param("type") String type) {
        logger.info("type:{},id:{}", type, id);
        Article article = articleService.get(id);
        return Rets.success(article);
    }
}
