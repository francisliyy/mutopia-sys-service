/**
 * <p>Title: SysUserRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.sys.model.user.SysUser;

@org.springframework.stereotype.Repository
public interface SysUserRepository extends Repository<SysUser, Integer> {
	
	SysUser save(SysUser user);

}
