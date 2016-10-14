package com.ic.user.controller;

import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ic.common.controller.BaseController;
import com.ic.common.model.SysUser;
import com.ic.common.utils.LoggerUtils;
import com.ic.core.shiro.token.manager.TokenManager;
import com.ic.user.manager.UserManager;
import com.ic.user.service.SysUserService;

/**
 * 
 * 用户管理
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("user")
public class UserCoreController extends BaseController {

	@Resource
	SysUserService userService;
	/**
	 * 个人资料
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView userIndex(){
		
		return new ModelAndView("user/index");
	}
	
	
	/**
	 * 偷懒一下，通用页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping(value="{page}",method=RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page")String page){
		return new ModelAndView(String.format("user/%s", page));
	}
	/**
	 * 密码修改
	 * @return
	 */
	@RequestMapping(value="updatePswd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updatePswd(String pswd,String newPswd){
		//根据当前登录的用户帐号 + 老密码，查询。
		String email = TokenManager.getToken().getEmail();
				pswd = UserManager.md5Pswd(email, pswd);
		SysUser user = userService.login(email, pswd);
		
		if("admin".equals(email)){
			resultMap.put("status", 300);
			resultMap.put("message", "管理员不准修改密码。");
			return resultMap;
		}
		
		if(null == user){
			resultMap.put("status", 300);
			resultMap.put("message", "密码不正确！");
		}else{
			user.setPassword(newPswd);
			//加工密码
			user = UserManager.md5Pswd(user);
			//修改密码
			userService.updateByPrimaryKeySelective(user);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!");
			//重新登录一次
			TokenManager.login(user, Boolean.TRUE);
		}
		return resultMap;
	}
	/**
	 * 个人资料修改
	 * @return
	 */
	@RequestMapping(value="updateSelf",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateSelf(SysUser entity){
		try {
			userService.updateByPrimaryKeySelective(entity);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败!");
			LoggerUtils.fmtError(getClass(), e, "修改个人资料出错。[%s]", JSONObject.fromObject(entity).toString());
		}
		return resultMap;
	}
}
