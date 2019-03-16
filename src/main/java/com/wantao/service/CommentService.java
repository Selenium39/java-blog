package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Comment;
import com.wantao.mapper.CommentMapper;

/**
 * @author wantao
 * @date 2019-02-14 12:00
 * @description: comment表
 */
@Service
public class CommentService implements CommentMapper {
	@Autowired
	CommentMapper commentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.CommentMapper#selectCommentCount() 查询评论数量
	 */
	@Override
	public Integer selectCommentCount() {
		return commentMapper.selectCommentCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.CommentMapper#selectAllComment() 查询所有的评论
	 */
	@Override
	public List<Comment> selectAllComment() {
		return commentMapper.selectAllComment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.CommentMapper#deleteCommentByBatchById(java.util.List)
	 * 批量删除评论
	 */
	@Override
	public Integer deleteCommentByBatchById(List<Integer> ids) {
		return commentMapper.deleteCommentByBatchById(ids);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.CommentMapper#selectCommentsByArticleId(java.lang.Integer)
	 * 通过文章id查找到所有的评论
	 */
	@Override
	public List<Comment> selectCommentsByArticleId(Integer articleId) {
		return commentMapper.selectCommentsByArticleId(articleId);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.CommentMapper#insertComment(com.wantao.bean.Comment)
	 * 增加一条评论
	 */
	@Override
	public Integer insertComment(Comment comment) {
		return commentMapper.insertComment(comment);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.CommentMapper#selectCommentPostion(java.lang.Integer)
	 * 查询评论在表中的位置（评论楼层显示）但是后来发现直接按create time排序就行了
	 */
	@Override
	public Integer selectCommentPostion(Integer commentId) {
		return commentMapper.selectCommentPostion(commentId);
	}

	@Override
	public Integer selectNewCommentCount() {
		return commentMapper.selectNewCommentCount();
	}

	@Override
	public Integer updateCommentByBatchById(List<Integer> ids) {
		return commentMapper.updateCommentByBatchById(ids);
	}

	@Override
	public Integer updateAllComment() {
		return commentMapper.updateAllComment();
	}

}
