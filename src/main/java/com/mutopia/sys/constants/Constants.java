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

}
