package com.mutopia.sys.model.user;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_user_role_rel_his database table.
 * 
 */
@Entity
@Table(name="sys_user_role_rel_his")
@NamedQuery(name="SysUserRoleRelHi.findAll", query="SELECT s FROM SysUserRoleRelHi s")
public class SysUserRoleRelHi extends com.mutopia.sys.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="create_user")
	private long createUser;

	@Column(name="role_id")
	private int roleId;

	private String status;

	@Column(name="update_time")
	private Date updateTime;

	@Column(name="update_user")
	private long updateUser;

	@Column(name="user_id")
	private long userId;

	@Column(name="user_role_rel_id")
	private long userRoleRelId;

	public SysUserRoleRelHi() {
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(long createUser) {
		this.createUser = createUser;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(long updateUser) {
		this.updateUser = updateUser;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserRoleRelId() {
		return this.userRoleRelId;
	}

	public void setUserRoleRelId(long userRoleRelId) {
		this.userRoleRelId = userRoleRelId;
	}

}