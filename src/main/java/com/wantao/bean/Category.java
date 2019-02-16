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
 * @param categoryId
 * @param categoryPid
 * @param categoryName
 * @param categoryDescription
 * @param categoryOrder
 * @param categoryIcon
 * @param articleCount
 */
@AllArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = -6098698620797023853L;
	private Integer categoryId;
	private Integer categoryPid;
	private String categoryName;
	private String categoryDescription;
	private Integer categoryOrder;
	private String categoryIcon;
	/**
	 * @field Integer articleCount 文章数量,非数据库字段
	 */
	private Integer articleCount;

	public Category() {
	}

	public Category(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	/**
	 * @param
	 * @return Category
	 * @description :未分类
	 */
	public static Category Default() {
		return new Category(7777777,"未分类");
	}
}
