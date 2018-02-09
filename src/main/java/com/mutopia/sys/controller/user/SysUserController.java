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
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mutopia.sys.constants.Constants;
import com.mutopia.sys.exceptions.EmailExistException;
import com.mutopia.sys.exceptions.MobileExistException;
import com.mutopia.sys.exceptions.SysMgtException;
import com.mutopia.sys.model.user.SysUser;
import com.mutopia.sys.service.user.SysUserService;
import com.mutopia.sys.utils.DateUtil;
import com.mutopia.sys.utils.Md5Encrypt;
import com.mutopia.sys.vo.MailVo;
import com.mutopia.sys.vo.SmsVo;

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
	
	private Random rNo = new Random();
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@ApiOperation(value="创建用户", notes="根据SysUser对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/")
    public SysUser initCreationForm(@Valid @RequestBody SysUser user, BindingResult result) throws MethodArgumentNotValidException{
		
		String verifyCode = "";
		
        if (result.hasErrors()) {        	
        	throw new MethodArgumentNotValidException(null, result);	
        }	
        
        if(user.getEmail()==null&&"".equals(user.getEmail())&&user.getMobile()==null&&"".equals(user.getMobile())){
        	ObjectError objErr = new ObjectError("customer error", "请输入手机号或电子邮箱地址");
        	result.addError(objErr);
        	throw new MethodArgumentNotValidException(null, result);
        }
        
        if(!"".equals(user.getMobile())){//手机验证激活
        	
        	//通过手机号验证用户是否已存在
            SysUser existUser = this.sysUserService.getUserByMobile(user.getMobile());
            if(existUser!=null){
            	throw new MobileExistException(user.getMobile());
            } 
            
        	verifyCode = rNo.nextInt((999999 - 100000) + 1) + 100000 +"";
        }else if(!"".equals(user.getEmail())){//邮件激活
        	
        	//通过邮箱验证用户是否已存在
            SysUser existUser = this.sysUserService.getUserByEmail(user.getEmail());
            if(existUser!=null){
            	throw new EmailExistException(user.getEmail());
            }            
            
        	verifyCode = Md5Encrypt.encodeByMD5("email"+user.getEmail());            
        }
        user.setVerifycode(verifyCode);
        user.setStatus(Constants.USER_STATUS_FORBIDDEN);
        SysUser newuser = this.sysUserService.createUser(user);
        
        if(!"".equals(user.getMobile())){//手机验证激活        	
        	sendValidMobile(user,verifyCode);
        	
        }else if(!"".equals(user.getEmail())){//邮件激活
        	sendValidEmail(user, verifyCode);
        	
        }
        
        return newuser;
    }
	
	@ApiOperation(value="邮箱激活账户", notes="通过邮件激活账户")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "email", value = "用户邮箱", required = true, dataType = "String"),
		@ApiImplicitParam(name = "validateCode", value = "验证码", required = true, dataType = "String")
	})	
	@GetMapping("/mailactivate/{email}/{validateCode}")
	public String mailActivate(@PathVariable String email , @PathVariable String validateCode) throws SysMgtException{
		
		SysUser user = this.sysUserService.getUserByEmail(email);
		
		//验证用户是否存在   
        if(user!=null) {    
            //验证用户激活状态    
            if(Constants.USER_STATUS_FORBIDDEN.equals(user.getStatus())) {   
                ///没激活  
                Date currentTime = new Date();//获取当前时间    
                //验证链接是否过期   
                if(currentTime.before(DateUtil.addMinute(user.getCreateTime(), Constants.EXPIRE_MINUTES))){
                	//验证激活码是否正确    
                    if(validateCode.equals(user.getVerifycode())) {    
                        //激活成功， //并更新用户的激活状态，为已激活   
                        System.out.println("==sq==="+user.getStatus());  
                        user.setStatus(Constants.USER_STATUS_ACTIVIATED);//把状态改为激活  
                        user.setActiveTime(new Date());
                        System.out.println("==sh==="+user.getStatus());  
                        this.sysUserService.updateUser(user);  
                    } else { 
                    }
                }else{                	
                    throw new SysMgtException("激活码已过期！");  
                }                  
            } else {  
               throw new SysMgtException("邮箱已激活，请登录！");    
            }    
        } else {  
            throw new SysMgtException("该邮箱未注册（邮箱地址不存在）！");    
        }
        
        return "1";
		
	}
	
	@ApiOperation(value="短信验证码激活账户", notes="通过短信验证码激活账户")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String"),
		@ApiImplicitParam(name = "validateCode", value = "验证码", required = true, dataType = "String")
	})	
	@GetMapping("/smsactivate/{mobile}/{validateCode}")
	public String smsActivate(@PathVariable String mobile , @PathVariable String validateCode) throws SysMgtException{
		
		SysUser user = this.sysUserService.getUserByMobile(mobile);
		
		//验证用户是否存在   
        if(user!=null) {    
            //验证用户激活状态    
            if(Constants.USER_STATUS_FORBIDDEN.equals(user.getStatus())) {   
                ///没激活  
                Date currentTime = new Date();//获取当前时间    
                //验证链接是否过期   
                if(currentTime.before(DateUtil.addMinute(user.getCreateTime(), Constants.EXPIRE_MINUTES))){
                	//验证激活码是否正确    
                    if(validateCode.equals(user.getVerifycode())) {    
                        //激活成功， //并更新用户的激活状态，为已激活   
                        System.out.println("==sq==="+user.getStatus());  
                        user.setStatus(Constants.USER_STATUS_ACTIVIATED);//把状态改为激活  
                        user.setActiveTime(new Date());
                        System.out.println("==sh==="+user.getStatus());  
                        this.sysUserService.updateUser(user);  
                    } else {    
                    	throw new SysMgtException("验证码错误，请重新输入！");   
                    }
                }else{
                    throw new SysMgtException("激活码已过期！");  
                }                  
            } else {  
               throw new SysMgtException("账号已激活，请登录！");    
            }    
        } else {  
            throw new SysMgtException("该手机号未注册！");    
        }
        
        return "1";
		
	}
	
	@ApiOperation(value="再次发送验证邮件", notes="再次发送验证邮件")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/sendVerifycodeByEmail")
    public String sendVerifycodeByEmail(@RequestBody SysUser user) throws SysMgtException {
		
    	String verifyCode = Md5Encrypt.encodeByMD5("email"+user.getEmail()); 
    	
    	Date currentTime = new Date();//获取当前时间    
        //验证链接是否过期   
        if(currentTime.before(DateUtil.addMinute(user.getCreateTime(), Constants.EXPIRE_MINUTES))){
        	throw new SysMgtException("激活邮件已发送至您的邮箱:"+user.getEmail()+",请查收后激活账号，谢谢！"); 
        }else if(Constants.USER_STATUS_ACTIVIATED.equals(user.getStatus())){
        	throw new SysMgtException("您的账号已激活，谢谢！"); 
        }else{           	
        	sendValidEmail(user, verifyCode);
        	user.setVerifycode(verifyCode);
        	user.setActiveTime(new Date());
        	this.sysUserService.updateUser(user);        	
        }
		
		return "1";		
	}	
	
	@ApiOperation(value="再次发送短信验证码", notes="再次发送短信验证码")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/sendVerifycodeByMobile")
    public String sendVerifycodeByMobile(@RequestBody SysUser user) throws SysMgtException {
		
		String verifyCode = rNo.nextInt((999999 - 100000) + 1) + 100000 +""; 
    	
    	Date currentTime = new Date();//获取当前时间    
        //验证链接是否过期   
        if(currentTime.before(DateUtil.addMinute(user.getCreateTime(), Constants.EXPIRE_MINUTES))){
        	throw new SysMgtException("短信验证码已发送至您的手机:"+user.getMobile()+",请查收后激活账号，谢谢！"); 
        }else if(Constants.USER_STATUS_ACTIVIATED.equals(user.getStatus())){
        	throw new SysMgtException("您的账号已激活，谢谢！"); 
        }else{           	
        	sendValidMobile(user, verifyCode); 
        	user.setVerifycode(verifyCode);
        	user.setActiveTime(new Date());
        	this.sysUserService.updateUser(user);
        }
		
		return "1";		
	}

	private void sendValidEmail(SysUser user,String verifyCode) {
		/**
		 * 发送激活邮件
		 */
		MailVo mailObj = new MailVo();
		RestTemplate restTemplate = new RestTemplate();
		
		///邮件的内容  
		StringBuffer contentsb=new StringBuffer("点击下面链接激活账号，链接只能使用一次，请尽快激活！</br>");  
		contentsb.append("<a href="+this.env.getProperty("mutopia.sysmgt.system")+"/user/mailactivate/");  
		contentsb.append(user.getEmail());   
		contentsb.append("/");   
		contentsb.append(verifyCode);  
		contentsb.append("\">激活妙天平台账号"); 
		contentsb.append("</a>");
		
		mailObj.setMailReceiver(user.getEmail());
		mailObj.setMailSubject("妙天平台账号激活邮件");
		mailObj.setMailContent(contentsb.toString());
		mailObj.setIsImmediate(Constants.MSG_SEND_IMMEDIATE);
		mailObj.setMailSourceSystem(Constants.CURRENT_SYSTEM);
		mailObj.setMailSourceCtlUrl("/user");
		mailObj.setMailTime(new Date());
		
		restTemplate.postForEntity(this.env.getProperty("mutopia.msg.system")+"/mail/", mailObj,Boolean.class);
	}

	private void sendValidMobile(SysUser user,String verifyCode) {
		SmsVo smsvo = new SmsVo();
		RestTemplate restTemplate = new RestTemplate();
		
		smsvo.setSmsReceiver(user.getMobile());
		smsvo.setSmsContent(verifyCode);
		smsvo.setIsImmediate(Constants.MSG_SEND_IMMEDIATE);
		smsvo.setSmsSourceSystem(Constants.CURRENT_SYSTEM);
		smsvo.setSmsSourceCtlUrl("/user");
		smsvo.setSmsTime(new Date());
		
		restTemplate.postForEntity(this.env.getProperty("mutopia.msg.system")+"/alisms/", smsvo,Boolean.class);
	}
	
}
