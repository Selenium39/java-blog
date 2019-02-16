package com.wantao.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author wantao
 * @date 2019-02-14 11:51
 * @description: message表
 */
@Repository
public interface MessageMapper {
	public Integer selectMessageCount();

}
