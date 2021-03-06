/**
 * <p>Title: SysUserRepository</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mutopia.sys.model.user.SysUser;

@org.springframework.stereotype.Repository
public interface SysUserRepository extends Repository<SysUser, Long> {
	
	@Query("SELECT DISTINCT user FROM SysUser user WHERE user.email = :email")
    @Transactional(readOnly = true)	
	SysUser findByEmail(@Param("email") String email);
	
	@Query("SELECT DISTINCT user FROM SysUser user WHERE user.mobile = :mobile")
    @Transactional(readOnly = true)	
	SysUser findByMobile(@Param("mobile") String mobile);
	
	@Transactional(readOnly = true)
	SysUser findById(Integer id);
	
	@Query("SELECT DISTINCT user FROM SysUser user WHERE (user.mobile = :loginName or user.email = :loginName) and password = :password")
    @Transactional(readOnly = true)	
	SysUser findByLoginNameAndPassword(@Param("loginName") String loginName,@Param("password")String password);
	
	SysUser save(SysUser user);

}
