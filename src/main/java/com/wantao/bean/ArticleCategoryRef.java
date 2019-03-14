package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-03-14 3:54:54 PM
 * @description 文章分类映射类
 */
/**
 * @param articleId 文章id
 * @param categoryId 分类id
 */
@Data
@AllArgsConstructor
public class ArticleCategoryRef implements Serializable {
	private static final long serialVersionUID = 5736878133764918184L;
	private Integer articleId;
	private Integer categoryId;
	public ArticleCategoryRef() {
		
	};

}
