package com.ic.user.manager;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ic.common.model.SysResource;
import com.ic.common.model.SysRole;
import com.ic.common.model.SysUser;
import com.ic.common.utils.MathUtil;

public class UserManager {
	
	/**
	 * 加工密码，和登录一致。
	 * @param user
	 * @return
	 */
	public static SysUser md5Pswd(SysUser user){
		//密码为   email + '#' + pswd，然后MD5
		user.setPassword(md5Pswd(user.getEmail(),user.getPassword()));
		return user;
	}
	/**
	 * 字符串返回值
	 * @param email
	 * @param pswd
	 * @return
	 */
	public static String md5Pswd(String email ,String pswd){
		pswd = String.format("%s#%s", email,pswd);
		pswd = MathUtil.getMD5(pswd);
		return pswd;
	}
	/**
	 * 把查询出来的roles 转换成bootstarp 的 tree数据
	 * @param roles
	 * @return
	 */
	public static List<Map<String,Object>> toTreeData(List<SysRole> roles){
		List<Map<String,Object>> resultData = new LinkedList<Map<String,Object>>();
		for (SysRole u : roles) {
			//角色列表
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("text", u.getName());//名称
			map.put("href", "javascript:void(0)");//链接
			List<SysResource> ps = u.getResources();
			map.put("tags",  new Integer[]{ps.size()});//显示子数据条数
			if(null != ps && ps.size() > 0){
				List<Map<String,Object>> list = new LinkedList<Map<String,Object>>();
				//权限列表
				for (SysResource up : ps) {
					Map<String,Object> mapx = new LinkedHashMap<String, Object>();
					mapx.put("text", up.getName());//权限名称
					mapx.put("href", up.getUrl());//权限url
					//mapx.put("tags", "0");//没有下一级
					list.add(mapx);
				}
				map.put("nodes", list);
			}
			resultData.add(map);
		}
		return resultData;
		
	}
	
	
}
