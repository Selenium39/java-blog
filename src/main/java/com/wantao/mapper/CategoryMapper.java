package com.wantao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Article;
import com.wantao.bean.Category;

/**
 * @author wantao
 * @date 2019-03-06 23:05
 * @description: category表
 */
@Repository
public interface CategoryMapper {
    public List<Category> selectAllCategory();
    public List<Map<String, Object>>selectAllCategoryIdAndName();
    public Category selectCategoryById(Integer id);
    public Integer deleteCategoryByBatchById(List<Integer>ids);
    public Integer updateCategoryById(Category category);
    public Integer insertCategory(Category category);
}
