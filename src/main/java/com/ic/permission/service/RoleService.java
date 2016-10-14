package com.ic.permission.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ic.common.model.SysRole;
import com.ic.core.mybatis.page.Pagination;
import com.ic.permission.bo.RolePermissionAllocationBo;

public interface RoleService {

	int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

	SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	Pagination<SysRole> findPage(Map<String, Object> resultMap, Integer pageNo,
							   Integer pageSize);

	Map<String, Object> deleteRoleById(String ids);

	Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
			Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	//根据用户ID查询角色（role），放入到Authorization里。
	Set<String> findRoleByUserId(Long userId);

	List<SysRole> findNowAllPermission();
	//初始化数据
	void initData();
}
