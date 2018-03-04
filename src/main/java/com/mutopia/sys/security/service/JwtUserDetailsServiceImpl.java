/**
 * <p>Title: JwtUserDetailsServiceImpl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.repository.SysUserRepository;
import com.mutopia.sys.security.JWTUserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    private SysUserRepository sysUserRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SysUser user = this.sysUserRepository.findByMobile(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with mobile '%s'.", username));
        } else {
            return JWTUserFactory.create(user);
        }
	}

}
