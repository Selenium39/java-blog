package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Tag;
import com.wantao.mapper.TagMapper;

/**
 * @author wantao
 * @date 2019-03-06 23:43
 * @description: Tag表
 */
@Service
public class TagService implements TagMapper {
	@Autowired
	TagMapper TagMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.TagMapper#selectAllTag() 查询所有的分类
	 */
	@Override
	public List<Tag> selectAllTag() {
		return TagMapper.selectAllTag();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wantao.mapper.TagMapper#deleteTagByBatchById(java.util.List)
	 * 单个和批量删除分类
	 */
	@Override
	public Integer deleteTagByBatchById(List<Integer> ids) {
		return TagMapper.deleteTagByBatchById(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.TagMapper#selectTagById(java.lang.Integer)
	 * 根据id查看分类
	 */
	@Override
	public Tag selectTagById(Integer id) {
		return TagMapper.selectTagById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wantao.mapper.TagMapper#updateTagById(com.wantao.bean.Tag)
	 * 根据id修改分类
	 */
	@Override
	public Integer updateTagById(Tag tag) {
		return TagMapper.updateTagById(tag);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.TagMapper#insertTag(com.wantao.bean.Tag)
	  * 增加分类
	 */
	@Override
	public Integer insertTag(Tag tag) {
		return TagMapper.insertTag(tag);
	}

}
