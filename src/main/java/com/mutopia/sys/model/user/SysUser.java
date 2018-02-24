package com.mutopia.sys.model.user;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;

import java.util.Date;


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

	//@Column(name="active_time",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Column(name="active_time")
	private Date activeTime;

	private String alipay;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@Column(name="create_time")
	private Date createTime;

	@Email
	private String email;

	private String gender;

	private String logo;

	@Pattern(regexp="^1[3|4|5|7|8]\\d{9}$",message="手机号码有误")
	private String mobile;

	private String name;

	private String nickname;
	
	@Size(min = 6, message = "您的密码需为大于等于6位")
	private String password;

	private String qq;

	private String status;

	private String type;

	private String wechat;
	
	private String verifycode;
	
	@Column(name="verify_time")
	private Date verifyTime;

	public SysUser() {
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public Date getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Date activeTime) {
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
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