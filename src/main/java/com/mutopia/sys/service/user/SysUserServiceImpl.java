/**
 * <p>Title: SysUserServiceImpl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.repository.SysUserRepository;
import com.mutopia.sys.utils.Md5Encrypt;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	
	@Override
	public SysUser getUserByEmail(String email) {
		return this.sysUserRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.mutopia.sys.service.user.SysUserService#createUser(com.mutopia.sys.model.user.SysUser)
	 */
	@Override
	public SysUser createUser(SysUser user) {
		
		SysUser newuser = new SysUser();
		BeanUtils.copyProperties(user, newuser);
		
		newuser.setPassword(Md5Encrypt.encodeByMD5(user.getPassword()));
		
		// TODO Auto-generated method stub
		return this.sysUserRepository.save(user);
	}

}
