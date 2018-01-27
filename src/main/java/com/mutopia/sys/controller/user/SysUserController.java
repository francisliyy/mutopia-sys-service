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

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.service.user.SysUserService;

@RestController
@RequestMapping("/user")
public class SysUserController {
	
	private SysUserService sysUserService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "Hello world";
    }
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@PostMapping("/{nickname}")
    public SysUser initCreationForm(@Valid @RequestBody SysUser user, BindingResult result, @PathVariable String nickname) throws MethodArgumentNotValidException {
		
		SysUser sysuser = new SysUser();
		sysuser.setNickname("");
		
		if (StringUtils.hasLength(sysuser.getNickname())){
            result.rejectValue("name", "duplicate", "already exists");
        }
		
        if (result.hasErrors()) {        	
        	throw new MethodArgumentNotValidException(null, result);	
        }	
        
        SysUser newuser = this.sysUserService.createUser(sysuser);
		//model.put("owner", owner);
        return newuser;
    }

}
