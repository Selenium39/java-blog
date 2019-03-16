package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.mapper.MessageMapper;
import com.wantao.bean.Message;

/**
 * @author wantao
 * @date 2019-02-14 12:25
 * @description: message表
 */
@Service
public class MessageService implements MessageMapper {
	@Autowired
	MessageMapper messageMapper;

	/* (non-Javadoc)
	 * @see com.wantao.mapper.MessageMapper#selectMessageCount()
	 * 查看留言数量
	 */
	@Override
	public Integer selectMessageCount() {
		return messageMapper.selectMessageCount();
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.MessageMapper#selectAllMessage()
	 * 查看所有留言
	 */
	@Override
	public List<Message> selectAllMessage() {
		return messageMapper.selectAllMessage();
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.MessageMapper#deleteMessageByBatchById(java.util.List)
	 * 单个或者批量删除留言
	 */
	@Override
	public Integer deleteMessageByBatchById(List<Integer> ids) {
		return messageMapper.deleteMessageByBatchById(ids);
	}

	@Override
	public Integer selectNewMessageCount() {
		return messageMapper.selectNewMessageCount();
	}

	@Override
	public Integer updateMessageByBatchById(List<Integer> ids) {
		return messageMapper.updateMessageByBatchById(ids);
	}

	@Override
	public Integer updateAllMessage() {
		return messageMapper.updateAllMessage();
	}

	@Override
	public Integer insertMessage(Message message) {
		return messageMapper.insertMessage(message);
	}

}
