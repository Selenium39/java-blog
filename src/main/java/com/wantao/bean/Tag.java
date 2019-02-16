package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author wantao
 * @date 2019-02-12 14:18
 * @description:标签类
 */
@Data
/**
 * @param tagId
 * @param tagName
 * @param tagDescription
 * @param articleCount
 */
@AllArgsConstructor
public class Tag implements Serializable {
	private static final long serialVersionUID = -2317208166946788710L;
	private Integer tagId;
	private String tagName;
	private String tagDescription;
	/**
	 * @field Integer articleCount 文章数量,不是数据库字段
	 */
	private Integer articleCount;

	public Tag() {
	}

	public Tag(Integer tagId) {
		this.tagId = tagId;
	}
}
