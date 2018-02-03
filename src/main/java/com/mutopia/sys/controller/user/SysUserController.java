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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mutopia.sys.constants.Constants;
import com.mutopia.sys.exceptions.EmailExistException;
import com.mutopia.sys.exceptions.SysMgtException;
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
	
	/*@InitBinder
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SysUserValidator());
    }*/
	
	@ApiOperation(value="创建用户", notes="根据SysUser对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "SysUser")
	@PostMapping("/")
    public SysUser initCreationForm(@Valid @RequestBody SysUser user, BindingResult result) throws MethodArgumentNotValidException {
		
		String verifyCode = "";
		
        if (result.hasErrors()) {        	
        	throw new MethodArgumentNotValidException(null, result);	
        }	
        
        //通过邮箱验证用户是否已存在
        SysUser existUser = this.sysUserService.getUserByEmail(user.getEmail());
        if(existUser!=null){
        	throw new EmailExistException(user.getEmail());
        }
        
        user.setStatus(Constants.USER_STATUS_FORBIDDEN);
        
        if(!"".equals(user.getMobile())){//手机验证激活
        	
        }else if(!"".equals(user.getEmail())){//邮件激活
        	verifyCode = Md5Encrypt.encodeByMD5("email"+user.getEmail());
            
        }
        user.setVerifycode(verifyCode);
        SysUser newuser = this.sysUserService.createUser(user);
        
        RestTemplate restTemplate = new RestTemplate();
        
        if(!"".equals(user.getMobile())){//手机验证激活
        	
        }else if(!"".equals(user.getEmail())){//邮件激活
        	/**
             * 发送激活邮件
             */
        	MailObj mailObj = new MailObj();
            
    		///邮件的内容  
            StringBuffer contentsb=new StringBuffer("点击下面链接激活账号，链接只能使用一次，请尽快激活！</br>");  
            contentsb.append("<a href=\"http://localhost:8080/user/mailactivate/");  
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
                currentTime.before(user.getCreateTime());  
              //验证激活码是否正确    
                if(validateCode.equals(user.getVerifycode())) {    
                    //激活成功， //并更新用户的激活状态，为已激活   
                    System.out.println("==sq==="+user.getStatus());  
                    user.setStatus(Constants.USER_STATUS_ACTIVIATED);//把状态改为激活  
                    user.setActiveTime(new Date());
                    System.out.println("==sh==="+user.getStatus());  
                    this.sysUserService.updateUser(user);  
                } else {    
                   throw new SysMgtException("激活码不正确");    
                }    
            } else {  
               throw new SysMgtException("邮箱已激活，请登录！");    
            }    
        } else {  
            throw new SysMgtException("该邮箱未注册（邮箱地址不存在）！");    
        }
        
        return "1";
		
	}
	
}
