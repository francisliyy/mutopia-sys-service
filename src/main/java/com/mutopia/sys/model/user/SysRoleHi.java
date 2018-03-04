package com.mutopia.sys.model.user;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_role_his database table.
 * 
 */
@Entity
@Table(name="sys_role_his")
@NamedQuery(name="SysRoleHi.findAll", query="SELECT s FROM SysRoleHi s")
public class SysRoleHi extends com.mutopia.sys.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="create_user")
	private int createUser;

	private String description;

	private String name;

	@Column(name="role_id")
	private int roleId;

	private String status;

	@Column(name="update_time")
	private Date updateTime;

	@Column(name="update_user")
	private int updateUser;

	public SysRoleHi() {
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

}