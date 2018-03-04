/**
 * <p>Title: JwtUserFactory</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mutopia.sys.model.user.SysRole;
import com.mutopia.sys.model.user.SysUser;

public final class JWTUserFactory {
	
	private JWTUserFactory() {
    }

    public static JWTUser create(SysUser user) {
    	
		return new JWTUser(user.getId(), user.getMobile()!=null?user.getMobile():user.getEmail(),
				user.getActiveTime(), user.getAlipay(), user.getBirthday(), user.getCreateTime(), 
				user.getEmail(), user.getGender(), user.getLogo(), user.getMobile(), user.getName(),
				user.getNickname(), user.getPassword(), user.getQq(), user.getStatus(), user.getType(),
				user.getWechat(), user.getVerifycode(), user.getVerifyTime(), 
				mapToGrantedAuthorities(user.getRoles()));
    	
    }
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }

}
