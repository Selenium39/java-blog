package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Category;
import com.wantao.mapper.CategoryMapper;

/**
 * @author wantao
 * @date 2019-03-06 23:43
 * @description: category表
 */
@Service
public class CategoryService implements CategoryMapper {
	@Autowired
	CategoryMapper categoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.CategoryMapper#selectAllCategory() 查询所有的分类
	 */
	@Override
	public List<Category> selectAllCategory() {
		return categoryMapper.selectAllCategory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wantao.mapper.CategoryMapper#deleteCategoryByBatchById(java.util.List)
	 * 单个和批量删除分类
	 */
	@Override
	public Integer deleteCategoryByBatchById(List<Integer> ids) {
		return categoryMapper.deleteCategoryByBatchById(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.CategoryMapper#selectCategoryById(java.lang.Integer)
	  * 根据id查看分类
	 */
	@Override
	public Category selectCategoryById(Integer id) {
		return categoryMapper.selectCategoryById(id);
	}

}
