package com.ic.permission.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ic.common.model.SysResource;
import com.ic.core.mybatis.page.Pagination;
import com.ic.permission.bo.UPermissionBo;

public interface PermissionService {

	int deleteByPrimaryKey(Long id);

	SysResource insert(SysResource record);

	SysResource insertSelective(SysResource record);

	SysResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

	Map<String, Object> deletePermissionById(String ids);

	Pagination<SysResource> findPage(Map<String, Object> resultMap, Integer pageNo,
									 Integer pageSize);
	List<UPermissionBo> selectPermissionById(Long id);

	Map<String, Object> addPermission2Role(Long roleId, String ids);

	Map<String, Object> deleteByRids(String roleIds);
	//根据用户ID查询权限（permission），放入到Authorization里。
	Set<String> findPermissionByUserId(Long userId);
}
