package com.wantao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-03-14 3:55:49 PM
 * @description 文章标签映射类
 */
/**
 * @param articleId 文章id
 * @param tagId 标签id
 */
@Data
@AllArgsConstructor
public class ArticleTageRef {
   private Integer articleId;
   private Integer tagId;
   public ArticleTageRef() {
	   
   }
}
