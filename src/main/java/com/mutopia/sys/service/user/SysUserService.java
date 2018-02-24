/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import com.mutopia.sys.model.user.SysUser;

public interface SysUserService {
	
	SysUser createUser(SysUser user);
	
	SysUser smsVerifyUser(SysUser user);
	
	SysUser mobileRegisterUser(SysUser user);
	
	SysUser mailActivate(SysUser user);
	
	SysUser smsActivate(SysUser user);
	
	SysUser sendVerifycodeByEmail(SysUser user);
	
	SysUser sendVerifycodeByMobile(SysUser user);
	
	SysUser getUserById(Integer id);
	
	SysUser getUserByEmail(String email);
	
	SysUser getUserByMobile(String mobile);
	
	SysUser getByLoginNameAndPassword(String loginName,String password);

	SysUser modifyPassword(SysUser user);

	//TODO
    //void deleteUser(Long id);

}
