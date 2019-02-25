package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.util.Message;

/**
 * @author wantao
 * @date 2019-02-14 11:51
 * @description: message表
 */
@Repository
public interface MessageMapper {
	public Integer selectMessageCount();
	public List<Message> selectAllMessage();
	 public Integer deleteMessageByBatchById(List<Integer>ids);

}
