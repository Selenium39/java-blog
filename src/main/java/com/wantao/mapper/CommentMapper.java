package com.wantao.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author wantao
 * @date 2019-02-14 11:52
 * @description: comment表
 */
@Repository
public interface CommentMapper {
    public Integer selectCommentCount();
}
