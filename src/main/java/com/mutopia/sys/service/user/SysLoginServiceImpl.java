/**
 * <p>Title: SysLoginServiceImpl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutopia.sys.constants.Constants;
import com.mutopia.sys.exceptions.SysMgtException;
import com.mutopia.sys.model.user.SysLoginLog;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.repository.SysLoginLogRepository;

@Service
public class SysLoginServiceImpl implements SysLoginService {
	
	@Autowired
	private SysLoginLogRepository sysLoginLogRepository;

	/* (non-Javadoc)
	 * @see com.mutopia.sys.service.user.SysLoginService#login(com.mutopia.sys.model.user.SysLoginLog)
	 */
	@Override
	public SysUser login(SysUser user,String loginName) throws SysMgtException {

		SysLoginLog log = new SysLoginLog();
		if(user==null){
			
			log.setErrDesc("用户名或密码错误");
			log.setLoginName(loginName);
			log.setOptTime(new Date());
			log.setOptType(Constants.LOGIN_OPT);
			log.setStatus(Constants.NO_STATUS);
			this.sysLoginLogRepository.save(log);
			throw new SysMgtException("用户名或密码错误");	
			
		}else{
			
			log.setLoginName(loginName);
			log.setOptTime(new Date());
			log.setOptType(Constants.LOGIN_OPT);
			log.setStatus(Constants.YES_STATUS);
			if(loginName.equals(user.getMobile())){
				log.setLoginType("mobile");
			}else if(loginName.equals("email")){
				log.setLoginType("email");
			}
			log.setUserId(user.getId());
			this.sysLoginLogRepository.save(log);
		}
		
		return user;
	}

	/* (non-Javadoc)
	 * @see com.mutopia.sys.service.user.SysLoginService#logout(com.mutopia.sys.model.user.SysLoginLog)
	 */
	@Override
	public void logout(SysUser user) {
		SysLoginLog log = new SysLoginLog();
		log.setUserId(user.getId());
		log.setOptType(Constants.LOGOUT_OPT);
		log.setOptTime(new Date());
		log.setStatus(Constants.YES_STATUS);
		this.sysLoginLogRepository.save(log);
	}

}
