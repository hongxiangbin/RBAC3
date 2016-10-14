package com.ic.common.dao;

import com.ic.common.model.SysRole;
import com.ic.common.model.SysRole;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    Set<String> findRoleByUserId(Long id);

    List<SysRole> findNowAllPermission(Map<String, Object> map);

    void initData();
}