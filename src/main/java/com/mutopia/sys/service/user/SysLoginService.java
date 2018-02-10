/**
 * <p>Title: SysLoginService</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import com.mutopia.sys.exceptions.SysMgtException;
import com.mutopia.sys.model.user.SysUser;

public interface SysLoginService {
	
	SysUser login(SysUser user,String loginName) throws SysMgtException;
	
	void logout(SysUser user);

}
