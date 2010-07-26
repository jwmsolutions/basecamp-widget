package com.jwmsolutions.timeCheck.model;

import com.jwmsolutions.timeCheck.CoreObject;

public class Profile {
	private String username;
	private String password;
	private String basecampToken;
	private String basecampUrl;
	private boolean rememberAccount;
	private boolean rememberPassword;
	private boolean autoLogin;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBasecampToken() {
		return basecampToken;
	}
	public void setBasecampToken(String basecampToken) {
		this.basecampToken = basecampToken;
	}
	public String getBasecampUrl() {
		return basecampUrl;
	}
	public void setBasecampUrl(String basecampUrl) {
		this.basecampUrl = basecampUrl;
	}
	public boolean isRememberAccount() {
		return rememberAccount;
	}
	public void setRememberAccount(boolean rememberAccount) {
		this.rememberAccount = rememberAccount;
	}
	public boolean isRememberPassword() {
		return rememberPassword;
	}
	public void setRememberPassword(boolean rememberPassword) {
		this.rememberPassword = rememberPassword;
	}
	public boolean isAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}
}
