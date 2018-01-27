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
	
	SysUser getUserByEmail(String nickname);	
	
	//TODO
	//SysUser getUserByNic(Long id);	
	//TODO
	//SysUser updateUser(SysUser user);
	//TODO
    //void deleteUser(Long id);

}
