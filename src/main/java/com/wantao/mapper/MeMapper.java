package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Me;

/**
 * @author wantao
 * @date 2019-02-27 11:30
 * @description: me表
 */
@Repository
public interface MeMapper {
    public Me selectMe();
    public Integer updateMe(Me me);
}
