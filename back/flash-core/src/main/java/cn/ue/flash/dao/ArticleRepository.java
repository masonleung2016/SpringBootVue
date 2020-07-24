package cn.ue.flash.dao.cms;

import cn.ue.flash.bean.entity.cms.Article;
import cn.ue.flash.dao.BaseRepository;

import java.util.List;

/**
 * @Description: 查询指定栏目下所有文章列表
 * @Author: LCF
 * @Date: 2020/7/20 14:46
 * @Package: cn.ue.flash.dao.cms
 * @Version 1.0
 */

public interface ArticleRepository extends BaseRepository<Article, Long> {
    /**
     * @param idChannel
     * @return
     */
    List<Article> findAllByIdChannel(Long idChannel);
}
