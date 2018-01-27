package com.mutopia.sys.model.user;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the sys_user database table.
 * 
 */
@ApiModel(description = "用户对象", subTypes = {SysUser.class})
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser extends com.mutopia.sys.model.base.BaseEntity  {
	private static final long serialVersionUID = 1L;

	@Column(name="active_time")
	private Timestamp activeTime;

	private String alipay;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="create_time")
	private Timestamp createTime;

	@Email
	@NotNull(message="Your email must not be empty")
	private String email;

	private String gender;

	private String logo;

	@Digits(fraction = 0, integer = 11)
	private String mobile;

	private String name;

	@NotNull(message="Your nick name must not be empty")
	private String nickname;
	
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;

	private String qq;

	private String status;

	private String type;

	private String wechat;

	public SysUser() {
	}

	public Timestamp getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	public String getAlipay() {
		return this.alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

}