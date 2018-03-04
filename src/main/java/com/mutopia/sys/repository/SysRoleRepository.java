/**
 * <p>Title: SysRoleRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.sys.model.user.SysRole;

public interface SysRoleRepository extends Repository<SysRole, Long> {
	
	void save(SysRole owner);

}
