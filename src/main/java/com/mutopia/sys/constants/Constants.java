/**
 * <p>Title: Constants</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.constants;

public final class Constants {
	
	/**
	 * 当前系统定义
	 */
	public static final String CURRENT_SYSTEM = "MUTOPIA SYSTEM MANAGEMENT";
	
	/**
	 * YES,NO
	 */
	public static final String YES_STATUS = "1";
	public static final String NO_STATUS = "0";
	
	/**
	 * Dim_status
	 */
	public static final String DISABLED_STATUS = "0";
	public static final String ENABLED_STATUS = "1";
	public static final String DELETED_STATUS = "2";
	
	/**
	 * 是否即时发送消息定义
	 */
	// 消息即时发送
	public static final String MSG_SEND_IMMEDIATE = "1";
	// 消息非即时发送
	public static final String MSG_SEND_LATER = "0";
	
	/**
	 * 用户常量
	 */
	public static final String USER_CUSTOMER = "1";//玩家
	public static final String USER_BUSINESS = "2";//商家
	
	public static final String USER_STATUS_FORBIDDEN = "0";//禁用或未激活
	public static final String USER_STATUS_ACTIVIATED = "1";//正常
	public static final String USER_STATUS_DELETED = "2";//删除
	
	public static final String USER_SMS_VERIFY_REGISTER = "0";//注册短信验证
	public static final String USER_REGISTER = "1";//用户注册
	public static final String USER_MAIL_VERIFY_TIMEOUT = "2";//邮件验证码过期重发
	public static final String USER_MOBILE_VERIFY_TIMEOUT = "3";//短信验证码过期重发
	public static final String USER_CHANGE_PASSWD = "4";//修改密码
	public static final String USER_MAIL_ACTIVATE = "5";//邮件修改密码
	public static final String USER_MOBIL_ACTIVATE = "6";//短信修改密码
	
	/**
	 * 过期时间，15分钟
	 */
	public static final int EXPIRE_MINUTES = 15;
	
	/**
	 * 登陆，退出
	 */
	public static final String LOGIN_OPT = "1";
	public static final String LOGOUT_OPT = "2";
	
	/**
	 * 角色
	 */
	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_USER = 2;
	
	
	

}
