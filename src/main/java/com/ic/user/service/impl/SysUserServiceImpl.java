package com.ic.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ic.common.model.SysUserRoleKey;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.ic.common.dao.SysUserMapper;
import com.ic.common.dao.SysUserRoleMapper;
import com.ic.common.model.SysUser;
import com.ic.common.model.SysRoleResourceKey;
import com.ic.common.utils.LoggerUtils;
import com.ic.core.mybatis.BaseMybatisDao;
import com.ic.core.mybatis.page.Pagination;
import com.ic.core.shiro.session.CustomSessionManager;
import com.ic.core.shiro.token.manager.TokenManager;
import com.ic.permission.bo.URoleBo;
import com.ic.permission.bo.UserRoleAllocationBo;
import com.ic.user.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseMybatisDao<SysUserMapper> implements SysUserService {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	CustomSessionManager customSessionManager;
	@Autowired
	SysUserMapper userMapper;
	@Autowired
	SysUserRoleMapper userRoleMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysUser insert(SysUser entity) {
		userMapper.insert(entity);
		return entity;
	}

	@Override
	public SysUser insertSelective(SysUser entity) {
		userMapper.insertSelective(entity);
		return entity;
	}

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SysUser entity) {
		return userMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser entity) {
		return userMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public SysUser login(String email , String pswd) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pswd", pswd);
		SysUser user = userMapper.login(map);
		return user;
	}

	@Override
	public SysUser findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SysUser> findByPage(Map<String, Object> resultMap,
										Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> deleteUserById(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int count=0;
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			for (String id : idArray) {
				count+=this.deleteByPrimaryKey(new Long(id));
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> updateForbidUserById(Long id, Short status) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			SysUser user = selectByPrimaryKey(id);
			user.setStatus(status);
			updateByPrimaryKeySelective(user);
			
			//如果当前用户在线，需要标记并且踢出
			customSessionManager.forbidUserById(id,status);
			
			
			resultMap.put("status", 200);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "操作失败，请刷新再试！");
			LoggerUtils.fmtError(getClass(), "禁止或者激活用户登录失败，id[%s],status[%s]", id,status);
		}
		return resultMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage("findUserAndRole", "findCount", modelMap, pageNo, pageSize);
	}

	@Override
	public List<URoleBo> selectRoleByUserId(Long id) {
		return userMapper.selectRoleByUserId(id);
	}

	@Override
	public Map<String, Object> addRole2User(Long userId, String ids) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int count = 0;
		try {
			//先删除原有的。
			userRoleMapper.deleteByUserId(userId);
			//如果ids,role 的id 有值，那么就添加。没值象征着：把这个用户（userId）所有角色取消。
			if(StringUtils.isNotBlank(ids)){
				String[] idArray = null;
				
				//这里有的人习惯，直接ids.split(",") 都可以，我习惯这么写。清楚明了。
				if(StringUtils.contains(ids, ",")){
					idArray = ids.split(",");
				}else{
					idArray = new String[]{ids};
				}
				//添加新的。
				for (String rid : idArray) {
					//这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的} 
					if(StringUtils.isNotBlank(rid)){
						SysUserRoleKey entity = new SysUserRoleKey(userId,new Long(rid));
						count += userRoleMapper.insertSelective(entity);
					}
				}
			}
			resultMap.put("status", 200);
			resultMap.put("message", "操作成功");
		} catch (Exception e) {
			resultMap.put("status", 200);
			resultMap.put("message", "操作失败，请重试！");
		}
		//清空用户的权限，迫使再次获取权限的时候，得重新加载
		TokenManager.clearUserAuthByUserId(userId);
		resultMap.put("count", count);
		return resultMap;
	}

	@Override
	public Map<String, Object> deleteRoleByUserIds(String userIds) {

		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("userIds", userIds);
			userRoleMapper.deleteRoleByUserIds(resultMap);
			resultMap.put("status", 200);
			resultMap.put("message", "操作成功");
		} catch (Exception e) {
			resultMap.put("status", 200);
			resultMap.put("message", "操作失败，请重试！");
		}
		return resultMap;
	
	}
	
	
	
}
