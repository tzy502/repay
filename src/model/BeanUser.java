package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class BeanUser {
	private String userId;
	private String userName;
	private String password;
	private String userJob;
	private String userPermissions;
	private String cardNumber;
	private String userPhone;
	
	@Id
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "userJob")
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	
	@Column(name = "userPermissions")
	public String getUserPermissions() {
		return userPermissions;
	}
	public void setUserPermissions(String userPermissions) {
		this.userPermissions = userPermissions;
	}
	
	@Column(name = "cardNumber")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "userPhone")
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}
