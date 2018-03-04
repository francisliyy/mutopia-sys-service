package com.mutopia.sys.model.user;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_user_role_rel database table.
 * 
 */
@Entity
@Table(name="sys_user_role_rel")
@NamedQuery(name="SysUserRoleRel.findAll", query="SELECT s FROM SysUserRoleRel s")
public class SysUserRoleRel extends com.mutopia.sys.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="create_user")
	private long createUser;

	@Column(name="role_id")
	private int roleId;

	private String status;

	@Column(name="user_id")
	private long userId;

	public SysUserRoleRel() {
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

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}