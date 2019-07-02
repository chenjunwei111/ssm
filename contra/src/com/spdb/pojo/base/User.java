package com.spdb.pojo.base;

import java.sql.Date;

/**
 * 用户信息表
 * @author chenjunwei
 *
 */
public class User {

	private int userId;
	private String userName;
    private String userPasswd;
    private String userAccount;
    private int userAge;
    private Date userDate;
    private String userEmail;
    private String userCity;
    private String userCityCode;
	
    private User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

//	public User(String userId, String userName, String userPasswd,
//			String userAccount, int userAge, Date userDate, String userEmail,
//			String userCity, String userCityCode) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.userPasswd = userPasswd;
//		this.userAccount = userAccount;
//		this.userAge = userAge;
//		this.userDate = userDate;
//		this.userEmail = userEmail;
//		this.userCity = userCity;
//		this.userCityCode = userCityCode;
//	}

	public String getUserCityCode() {
		return userCityCode;
	}

	public void setUserCityCode(String userCityCode) {
		this.userCityCode = userCityCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPasswd=" + userPasswd + ", userAccount=" + userAccount
				+ ", userAge=" + userAge + ", userDate=" + userDate
				+ ", userEmail=" + userEmail + ", userCity=" + userCity
				+ ", userCityCode=" + userCityCode + "]";
	}
	
}
