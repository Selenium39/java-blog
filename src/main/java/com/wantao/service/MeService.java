package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Me;
import com.wantao.mapper.MeMapper;

/**
 * @author wantao
 * @date 2019-02-27 11:32
 * @description: me表
 */
@Service
public class MeService implements MeMapper {
	@Autowired
    private MeMapper meMapper;
 
	/* (non-Javadoc)
	 * @see com.wantao.mapper.MeMapper#selectAllMe()
	   * 查询个人的所有信息
	 */
	public Me selectMe() {
		return meMapper.selectMe();
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.MeMapper#updateMe(com.wantao.bean.Me)
	 * 更新个人信息
	 */
	@Override
	public Integer updateMe(Me me) {
		return meMapper.updateMe(me);
	}

}
