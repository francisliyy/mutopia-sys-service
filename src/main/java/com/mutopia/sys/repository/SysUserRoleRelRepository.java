/**
 * <p>Title: SysUserRoleRelRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.sys.model.user.SysUserRoleRel;

@org.springframework.stereotype.Repository
public interface SysUserRoleRelRepository extends Repository<SysUserRoleRel, Long>{
	
	SysUserRoleRel save(SysUserRoleRel sysUserRoleRel);

}
