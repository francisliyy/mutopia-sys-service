/**
 * <p>Title: SysUserHiRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.repository.Repository;

import com.mutopia.sys.model.user.SysUserHi;

@org.springframework.stereotype.Repository
public interface SysUserHiRepository extends Repository<SysUserHi, Integer>{
	
	SysUserHi save(SysUserHi user);

}
