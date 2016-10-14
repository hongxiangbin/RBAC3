package com.ic.common.dao;

import com.ic.common.model.SysResource;
import com.ic.permission.bo.UPermissionBo;

import java.util.List;
import java.util.Set;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    List<UPermissionBo> selectPermissionById(Long id);
    //根据用户ID获取权限的Set集合
    Set<String> findPermissionByUserId(Long id);
}