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
	 * 是否即时发送消息定义
	 */
	// 消息即时发送
	public static final String MSG_SEND_IMMEDIATE = "1";
	// 消息非即时发送
	public static final String MSG_SEND_LATER = "0";
	
	/**
	 * 用户常量
	 */
	public static final String USER_STATUS_FORBIDDEN = "0";//禁用或未激活
	public static final String USER_STATUS_ACTIVIATED = "1";//正常
	public static final String USER_STATUS_DELETED = "2";//删除
	
	/**
	 * 过期时间，15分钟
	 */
	public static final int EXPIRE_MINUTES = 15;
	
	/**
	 * 登陆，退出
	 */
	public static final String LOGIN_OPT = "1";
	public static final String LOGOUT_OPT = "2";
	
	
	

}
