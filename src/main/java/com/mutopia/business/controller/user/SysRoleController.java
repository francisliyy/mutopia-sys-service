/**
 * <p>Title: SysRoleController</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.business.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mutopia.business.controller.base.BaseController;
import com.mutopia.business.model.user.SysRole;
import com.mutopia.business.repository.SysRoleRepository;

@Controller
public class SysRoleController extends BaseController{
	
	private final SysRoleRepository sysRoleRepository;
	
	@Autowired
    public SysRoleController(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }
	
	@PostMapping("/role/new")
    public @ResponseBody SysRole initCreationForm(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		SysRole role = new SysRole();
        role.setName(name);
        this.sysRoleRepository.save(role);
        //model.put("owner", owner);
        return role;
    }

}
