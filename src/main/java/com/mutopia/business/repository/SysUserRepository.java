/**
 * <p>Title: SysUserRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.business.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.business.model.user.SysUser;

public interface SysUserRepository extends Repository<SysUser, Integer> {
	
	void save(SysUser user);

}
