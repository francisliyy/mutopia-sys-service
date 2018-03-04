/**
 * <p>Title: SysUserRoleRelHiRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.sys.model.user.SysUserRoleRelHi;

@org.springframework.stereotype.Repository
public interface SysUserRoleRelHiRepository extends Repository<SysUserRoleRelHi, Long> {
	
	SysUserRoleRelHi save(SysUserRoleRelHi sysUserRoleRelHi);

}
