package com.ic.permission.controller;

import java.util.List;
import java.util.Map;

import com.ic.common.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ic.common.controller.BaseController;
import com.ic.common.model.SysRole;
import com.ic.common.utils.LoggerUtils;
import com.ic.core.mybatis.page.Pagination;
import com.ic.permission.service.RoleService;
import com.ic.user.manager.UserManager;
/**
 *
 * 用户角色管理
 *
 */
@Controller
@Scope(value="prototype")
@RequestMapping("role")
public class RoleController extends BaseController {
	@Autowired
	RoleService roleService;
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping(value="index")
	public ModelAndView index(String findContent,ModelMap modelMap){
		modelMap.put("findContent", findContent);
		Pagination<SysRole> role = roleService.findPage(modelMap,pageNo,pageSize);
		return new ModelAndView("role/index","page",role);
	}
	/**
	 * 角色添加
	 * @param role
	 * @return
	 */
	@RequestMapping(value="addRole",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addRole(SysRole role){
		try {
			int count = roleService.insertSelective(role);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加角色报错。source[%s]",role.toString());
		}
		return resultMap;
	}
	/**
	 * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @return
	 */
	@RequestMapping(value="deleteRoleById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteRoleById(String ids){
		return roleService.deleteRoleById(ids);
	}
	/**
	 * 我的权限页面
	 * @return
	 */
	@RequestMapping(value="mypermission",method=RequestMethod.GET)
	public ModelAndView mypermission(){
		return new ModelAndView("permission/mypermission");
	}
	/**
	 * 我的权限 bootstrap tree data
	 * @return
	 */
	@RequestMapping(value="getPermissionTree",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getPermissionTree(){
		//查询我所有的角色 ---> 权限
		List<SysRole> roles = roleService.findNowAllPermission();
		//把查询出来的roles 转换成bootstarp 的 tree数据
		List<Map<String, Object>> data = UserManager.toTreeData(roles);
		return data;
	}
}
