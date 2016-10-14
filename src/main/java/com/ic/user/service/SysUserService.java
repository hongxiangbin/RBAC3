package com.ic.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.ic.common.model.SysUser;
import com.ic.core.mybatis.page.Pagination;
import com.ic.permission.bo.URoleBo;
import com.ic.permission.bo.UserRoleAllocationBo;

public interface SysUserService {

	int deleteByPrimaryKey(Long id);

	SysUser insert(SysUser record);

	SysUser insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	SysUser login(String email, String pswd);

	SysUser findUserByEmail(String email);

	Pagination<SysUser> findByPage(Map<String, Object> resultMap, Integer pageNo,
								 Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Long id, Short status);

	Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
													 Integer pageNo, Integer pageSize);

	List<URoleBo> selectRoleByUserId(Long id);

	Map<String, Object> addRole2User(Long userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);
}
