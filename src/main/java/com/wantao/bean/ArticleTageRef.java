package com.wantao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleTageRef {
   private Integer articleId;
   private Integer tagId;
   public ArticleTageRef() {
	   
   }
}
