package com.wantao.service;

import java.util.List;
import java.util.Map;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wantao.mapper.CategoryMapper#updateCategoryById(com.wantao.bean.Category)
	 * 根据id修改分类
	 */
	@Override
	public Integer updateCategoryById(Category category) {
		return categoryMapper.updateCategoryById(category);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.CategoryMapper#insertCategory(com.wantao.bean.Category)
	  * 增加分类
	 */
	@Override
	public Integer insertCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}

	@Override
	public List<Map<String, Object>> selectAllCategoryIdAndName() {
		return categoryMapper.selectAllCategoryIdAndName();
	}

}
