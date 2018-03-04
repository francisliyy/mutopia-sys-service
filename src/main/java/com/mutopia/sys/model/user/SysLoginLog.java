package com.mutopia.sys.model.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_login_log database table.
 * 
 */
@Entity
@Table(name="sys_login_log")
@NamedQuery(name="SysLoginLog.findAll", query="SELECT s FROM SysLoginLog s")
public class SysLoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="app_id")
	private String appId;

	@Column(name="err_desc")
	private String errDesc;

	@Column(name="login_name")
	private String loginName;

	@Column(name="login_type")
	private String loginType;

	@Column(name="opt_time")
	private Date optTime;

	@Column(name="opt_type")
	private String optType;

	private String status;

	@Column(name="user_id")
	private long userId;

	public SysLoginLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getErrDesc() {
		return this.errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public Date getOptTime() {
		return this.optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public String getOptType() {
		return this.optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}