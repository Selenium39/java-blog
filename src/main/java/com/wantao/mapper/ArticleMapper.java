package com.wantao.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author wantao
 * @date 2019-02-13 23:03
 * @description:article表
 */
@Repository
public interface ArticleMapper {
   public Integer selectArticleCount();
}
