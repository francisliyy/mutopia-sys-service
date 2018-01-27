/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.business.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutopia.business.model.user.SysUser;
import com.mutopia.business.repository.SysUserRepository;

@Controller
@RequestMapping("/user")
public class SysUserController {
	
	private final SysUserRepository sysUserRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String sayHello() {
        return "Hello world";
    }
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@Autowired
    public SysUserController(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }
	
	@PostMapping("/{nickname}")
    public String initCreationForm(@Valid SysUser user, BindingResult result, @PathVariable String nickname) {
		
		SysUser sysuser = new SysUser();
		sysuser.setName(nickname);
		
		if (StringUtils.hasLength(sysuser.getNickname())){
            result.rejectValue("name", "duplicate", "already exists");
        }
		
        if (result.hasErrors()) {
        	
        	return result.getFieldError().toString();        	
        }		
        this.sysUserRepository.save(sysuser);
        //model.put("owner", owner);
        return "success";
    }

}
