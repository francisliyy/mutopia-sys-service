/**
 * <p>Title: JWTUser</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JWTUser implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private Date activeTime;
	private String alipay;
	private Date birthday;
	private Date createTime;
	private String email;
	private String gender;
	private String logo;
	private String mobile;
	private String name;
	private String nickname;
	private String password;
	private String qq;
	private String status;
	private String type;
	private String wechat;
	private String verifycode;
	private Date verifyTime;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JWTUser(Long id, String username, Date activeTime, String alipay, Date birthday, Date createTime,
			String email, String gender, String logo, String mobile, String name, String nickname, String password,
			String qq, String status, String type, String wechat, String verifycode, Date verifyTime,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.activeTime = activeTime;
		this.alipay = alipay;
		this.birthday = birthday;
		this.createTime = createTime;
		this.email = email;
		this.gender = gender;
		this.logo = logo;
		this.mobile = mobile;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.qq = qq;
		this.status = status;
		this.type = type;
		this.wechat = wechat;
		this.verifycode = verifycode;
		this.verifyTime = verifyTime;
		this.authorities = authorities;
	}
	public String getUserame() {
		return username;
	}
	public void setUserame(String username) {
		this.username = username;
		if(username.indexOf("@")>=0){
			this.setEmail(username);
		}else{
			this.setMobile(username);
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
	public String getAlipay() {
		return alipay;
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	public Date getVerifyTime() {
		return verifyTime;
	}
	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}
	
    @JsonIgnore
    public Long getId() {
        return id;
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
