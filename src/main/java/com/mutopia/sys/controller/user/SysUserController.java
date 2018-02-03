/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.controller.user;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mutopia.sys.constants.Constants;
import com.mutopia.sys.exceptions.EmailExistException;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.service.user.SysUserService;
import com.mutopia.sys.utils.Md5Encrypt;
import com.mutopia.sys.vo.MailObj;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户服务")
@RestController
@RequestMapping("/user")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
    private Environment env;
	
	/*@RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "Hello world";
    }*/
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@ApiOperation(value="创建用户", notes="根据SysUser对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/")
    public SysUser initCreationForm(@Valid @RequestBody SysUser user, BindingResult result) throws MethodArgumentNotValidException {
		
        if (result.hasErrors()) {        	
        	throw new MethodArgumentNotValidException(null, result);	
        }	
        
        //通过邮箱验证用户是否已存在
        SysUser existUser = this.sysUserService.getUserByEmail(user.getEmail());
        if(existUser!=null){
        	throw new EmailExistException(user.getEmail());
        }
        
        RestTemplate restTemplate = new RestTemplate();
        
        if(!"".equals(user.getMobile())){//手机验证激活
        	
        }else if(!"".equals(user.getEmail())){//邮件激活
        	/**
             * 发送激活邮件
             */
        	MailObj mailObj = new MailObj();
            String verifyCode = Md5Encrypt.encodeByMD5("email"+user.getEmail());
            user.setVerifycode(verifyCode);
            
    		///邮件的内容  
            StringBuffer contentsb=new StringBuffer("点击下面链接激活账号，链接只能使用一次，请尽快激活！</br>");  
            contentsb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");  
            contentsb.append(user.getEmail());   
            contentsb.append("&validateCode=");   
            contentsb.append(verifyCode);  
            contentsb.append("\">激活秒天平台账号"); 
            contentsb.append("</a>");
            
            mailObj.setMailReceiver(user.getEmail());
            mailObj.setMailSubject("秒天平台账号激活邮件");
            mailObj.setMailContent(contentsb.toString());
            mailObj.setIsImmediate(Constants.MSG_SEND_IMMEDIATE);
            mailObj.setMailSourceSystem(Constants.CURRENT_SYSTEM);
            mailObj.setMailSourceCtlUrl("/user");
            mailObj.setMailTime(new Date());
            
            ResponseEntity<Boolean> mailresult = restTemplate.postForEntity(this.env.getProperty("mutopia.msg.system")+"/mail/", mailObj,Boolean.class);
        	
        }
        
        SysUser newuser = this.sysUserService.createUser(user);
        
        return newuser;
    }
	
/*	@ApiOperation(value="注册邮件验证", notes="新注册用户通过邮件激活账户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mail", value = "源系统,功能URL", required = true, dataType = "MailSendLog"),
		@ApiImplicitParam(name = "email", value = "注册邮箱地址", required = true, dataType = "String"),
        @ApiImplicitParam(name = "verifycode", value = "验证码", required = true, dataType = "String"),
	})	
	@PostMapping("/register/{email}/{verifycode}")
	public boolean sendRegisterMail(@RequestBody MailSendLog mail,@PathVariable String email,@PathVariable String verifycode){
		
		
        
        MailSendLog maillog = new MailSendLog();
        maillog.setMailReceiver(email);
        maillog.setMailSubject("秒天平台账号激活邮件");
        maillog.setMailContent(sb.toString());
        maillog.setIsImmediate(Constants.MSG_SEND_IMMEDIATE);
        maillog.setMailSourceSystem(mail.getMailSourceSystem());
        maillog.setMailSourceCtlUrl(mail.getMailSourceCtlUrl());
        
        return this.mailService.sendImmediate(maillog);
		
	}*/

}
