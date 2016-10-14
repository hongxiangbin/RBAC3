package com.ic.common.dao;

import com.ic.common.model.SysUser;
import com.ic.permission.bo.URoleBo;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser login(Map<String, Object> map);

    SysUser findUserByEmail(String email);

    List<URoleBo> selectRoleByUserId(Long id);


}