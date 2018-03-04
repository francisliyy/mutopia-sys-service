/**
 * <p>Title: SysUserServiceImpl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mutopia.sys.constants.Constants;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.model.user.SysUserHi;
import com.mutopia.sys.model.user.SysUserRoleRel;
import com.mutopia.sys.model.user.SysUserRoleRelHi;
import com.mutopia.sys.repository.SysUserHiRepository;
import com.mutopia.sys.repository.SysUserRepository;
import com.mutopia.sys.repository.SysUserRoleRelHiRepository;
import com.mutopia.sys.repository.SysUserRoleRelRepository;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	
	@Autowired
	private SysUserHiRepository sysUserHiRepository;
	
	@Autowired
	private SysUserRoleRelRepository sysUserRoleRelRepository;
	
	@Autowired
	private SysUserRoleRelHiRepository sysUserRoleRelHiRepository;
	
	@Override
	public SysUser getUserById(Integer id) {
		return this.sysUserRepository.findById(id);
	}
	
	@Override
	public SysUser getUserByEmail(String email) {
		return this.sysUserRepository.findByEmail(email);
	}
	
	@Override
	public SysUser getUserByMobile(String mobile) {
		return this.sysUserRepository.findByMobile(mobile);
	}
	
	@Override
	public SysUser getByLoginNameAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return this.sysUserRepository.findByLoginNameAndPassword(loginName, password);
	}

	/* (non-Javadoc)
	 * @see com.mutopia.sys.service.user.SysUserService#createUser(com.mutopia.sys.model.user.SysUser)
	 */
	@Override
	public SysUser createUser(SysUser user) {
		
		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();
		SysUserRoleRel sysUserRoleRel = new SysUserRoleRel();
		SysUserRoleRelHi sysUserRoleRelHi = new SysUserRoleRelHi();
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setCreateTime(new Date());
		newuser = this.sysUserRepository.save(user);
		
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_REGISTER);		
		this.sysUserHiRepository.save(sysUserhi);
		
		sysUserRoleRel.setUserId(user.getId());
		sysUserRoleRel.setRoleId(Constants.ROLE_USER);
		sysUserRoleRel.setStatus(Constants.ENABLED_STATUS);
		sysUserRoleRel.setCreateUser(user.getId());
		sysUserRoleRel.setCreateTime(new Date());
		this.sysUserRoleRelRepository.save(sysUserRoleRel);
		
		BeanUtils.copyProperties(sysUserRoleRel, sysUserRoleRelHi);
		sysUserRoleRelHi.setUserRoleRelId(sysUserRoleRel.getId());
		sysUserRoleRelHi.setUpdateUser(sysUserRoleRel.getUserId());
		sysUserRoleRelHi.setUpdateTime(new Date());
		this.sysUserRoleRelHiRepository.save(sysUserRoleRelHi);
		
		return newuser;
	}
	
	@Override
	public SysUser smsVerifyUser(SysUser user) {
		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();
		user.setCreateTime(new Date());
		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_SMS_VERIFY_REGISTER);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}

	@Override
	public SysUser mailActivate(SysUser user) {

		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();

		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setCreateTime(newuser.getCreateTime());
		sysUserhi.setActiveTime(newuser.getActiveTime());
		sysUserhi.setVerifyTime(user.getVerifyTime());
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_MAIL_ACTIVATE);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}
	
	@Override
	public SysUser smsActivate(SysUser user) {

		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();

		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setCreateTime(newuser.getCreateTime());
		sysUserhi.setActiveTime(newuser.getActiveTime());
		sysUserhi.setVerifyTime(user.getVerifyTime());
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_MOBIL_ACTIVATE);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}
	
	@Override
	public SysUser sendVerifycodeByEmail(SysUser user) {

		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();

		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setCreateTime(newuser.getCreateTime());
		sysUserhi.setActiveTime(newuser.getActiveTime());
		sysUserhi.setVerifyTime(user.getVerifyTime());
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_MAIL_VERIFY_TIMEOUT);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}
	
	@Override
	public SysUser sendVerifycodeByMobile(SysUser user) {

		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();

		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setCreateTime(newuser.getCreateTime());
		sysUserhi.setActiveTime(newuser.getActiveTime());
		sysUserhi.setVerifyTime(user.getVerifyTime());
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_MOBILE_VERIFY_TIMEOUT);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}

	@Override
	public SysUser modifyPassword(SysUser user) {
		
		SysUser newuser = new SysUser();	
		SysUserHi sysUserhi = new SysUserHi();
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		newuser = this.sysUserRepository.save(user);
		BeanUtils.copyProperties(newuser, sysUserhi);
		sysUserhi.setCreateTime(newuser.getCreateTime());
		sysUserhi.setActiveTime(newuser.getActiveTime());
		sysUserhi.setVerifyTime(user.getVerifyTime());
		sysUserhi.setUserId(newuser.getId());
		sysUserhi.setUpdateUser(newuser.getId());
		sysUserhi.setUpdateTime(new Date());
		sysUserhi.setUpdateType(Constants.USER_CHANGE_PASSWD);
		this.sysUserHiRepository.save(sysUserhi);
		// TODO Auto-generated method stub
		
		return newuser;
	}

}
