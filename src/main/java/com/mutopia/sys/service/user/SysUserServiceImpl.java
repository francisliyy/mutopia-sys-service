/**
 * <p>Title: SysUserServiceImpl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.repository.SysUserRepository;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;

	/* (non-Javadoc)
	 * @see com.mutopia.sys.service.user.SysUserService#createUser(com.mutopia.sys.model.user.SysUser)
	 */
	@Override
	public SysUser createUser(SysUser user) {
		// TODO Auto-generated method stub
		return this.sysUserRepository.save(user);
	}

}
