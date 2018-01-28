/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutopia.sys.exceptions.EmailExistException;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.service.user.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户服务")
@RestController
@RequestMapping("/user")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/*@RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "Hello world";
    }*/
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@ApiOperation(value="创建用户", notes="根据SysUser对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/")
    public SysUser initCreationForm(@Valid @RequestBody SysUser user, BindingResult result) throws MethodArgumentNotValidException {
		
        if (result.hasErrors()) {        	
        	throw new MethodArgumentNotValidException(null, result);	
        }	
        
        //通过邮箱验证用户是否已存在
        SysUser existUser = this.sysUserService.getUserByEmail(user.getEmail());
        if(existUser!=null){
        	throw new EmailExistException(user.getEmail());
        }
        
        SysUser newuser = this.sysUserService.createUser(user);
        return newuser;
    }

}
