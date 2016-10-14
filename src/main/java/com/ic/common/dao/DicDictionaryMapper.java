package com.ic.common.dao;

import com.ic.common.model.DicDictionary;

public interface DicDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DicDictionary record);

    int insertSelective(DicDictionary record);

    DicDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DicDictionary record);

    int updateByPrimaryKey(DicDictionary record);
}