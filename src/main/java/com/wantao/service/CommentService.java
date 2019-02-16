package com.wantao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/* (non-Javadoc)
	 * @see com.wantao.mapper.CommentMapper#selectCommentCount()
	 * 查询评论数量
	 */
	@Override
	public Integer selectCommentCount() {
		return commentMapper.selectCommentCount();
	}

}
