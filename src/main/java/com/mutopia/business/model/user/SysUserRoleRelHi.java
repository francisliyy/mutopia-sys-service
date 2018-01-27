package com.mutopia.business.model.user;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sys_user_role_rel_his database table.
 * 
 */
@Entity
@Table(name="sys_user_role_rel_his")
@NamedQuery(name="SysUserRoleRelHi.findAll", query="SELECT s FROM SysUserRoleRelHi s")
public class SysUserRoleRelHi extends com.mutopia.business.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="create_user")
	private int createUser;

	@Column(name="role_id")
	private int roleId;

	private String status;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="update_user")
	private int updateUser;

	@Column(name="user_id")
	private int userId;

	@Column(name="user_role_rel_id")
	private int userRoleRelId;

	public SysUserRoleRelHi() {
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(int createUser) {
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

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRoleRelId() {
		return this.userRoleRelId;
	}

	public void setUserRoleRelId(int userRoleRelId) {
		this.userRoleRelId = userRoleRelId;
	}

}