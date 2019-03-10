package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleCategoryRef implements Serializable {
	private static final long serialVersionUID = 5736878133764918184L;
	private Integer articleId;
	private Integer categoryId;
	public ArticleCategoryRef() {
		
	};

}
