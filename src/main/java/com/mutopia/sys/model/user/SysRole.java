package com.mutopia.sys.model.user;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_role database table.
 * 
 */
@Entity
@Table(name="sys_role")
@NamedQuery(name="SysRole.findAll", query="SELECT s FROM SysRole s")
public class SysRole extends com.mutopia.sys.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="create_user")
	private int createUser;

	private String description;

	private String name;

	private String status;
	
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<SysUser> users;

	public SysRole() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SysUser> getUsers() {
		return users;
	}

	public void setUsers(List<SysUser> users) {
		this.users = users;
	}
	
}