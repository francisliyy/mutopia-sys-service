/**
 * <p>Title: SysLoginLogController</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutopia.sys.exceptions.SysMgtException;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.service.user.SysLoginService;
import com.mutopia.sys.service.user.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户登陆登出服务")
@RestController
public class SysLoginController {
	
	@Autowired
	private SysLoginService sysLoginService;
	
	@Autowired
	private SysUserService sysUserService;
	
	@ApiOperation(value="登陆", notes="用户通过手机、邮箱登陆")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "loginName", value = "登录名", required = true, dataType = "String"),
		@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
	})
	@PostMapping("/login")
	public SysUser login(@RequestParam String loginName,@RequestParam String password) throws SysMgtException{
		
		SysUser user = this.sysUserService.getByLoginNameAndPassword(loginName, password);
		user = this.sysLoginService.login(user,loginName);
		return user;
		
	}
	
	@ApiOperation(value="退出系统", notes="退出系统记录日志")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/logout")
	public void logout(@RequestBody SysUser user) throws SysMgtException{
		
		this.sysLoginService.logout(user);
		
	}

}
