package com.ic.common.dao;

import com.ic.common.model.SysRoleResourceKey;

import java.util.List;
import java.util.Map;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResourceKey record);

    int insertSelective(SysRoleResourceKey record);



    List<SysRoleResourceKey> findRolePermissionByPid(Long id);

    List<SysRoleResourceKey> findRolePermissionByRid(Long id);

    List<SysRoleResourceKey> find(SysRoleResourceKey entity);

    int deleteByPid(Long id);
    int deleteByRid(Long id);
    int delete(SysRoleResourceKey entity);

    int deleteByRids(Map<String, Object> resultMap);
}