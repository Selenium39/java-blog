package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wantao
 * @date 2019-02-14 00:26
 * @description: 分类类
 */
@Data
/**
 * @param categoryId          分类id
 * @param categoryName        分类name
 * @param categoryDescription 分类描述
 * @param categoryIcon        分类icon
 * @param articleCount
 */
@AllArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = -6098698620797023853L;
	private Integer categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryIcon;

	public Category() {
	}

	public Category(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
}
