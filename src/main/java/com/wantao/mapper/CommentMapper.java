package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Comment;

/**
 * @author wantao
 * @date 2019-02-14 11:52
 * @description: comment表
 */
@Repository
public interface CommentMapper {
    public Integer selectCommentCount();
    public List<Comment> selectAllComment();
    public Integer deleteCommentByBatchById(List<Integer>ids);
    public List<Comment> selectCommentsByArticleId(Integer articleId);
    public Integer insertComment(Comment comment);
}
