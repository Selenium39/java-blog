package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Tag;

/**
 * @author wantao
 * @date 2019-03-06 23:05
 * @description: Tag表
 */
@Repository
public interface TagMapper {
    public List<Tag> selectAllTag();
    public Tag selectTagById(Integer id);
    public Integer deleteTagByBatchById(List<Integer>ids);
    public Integer updateTagById(Tag Tag);
    public Integer insertTag(Tag Tag);
}
