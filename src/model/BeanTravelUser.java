package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traveluser")
public class BeanTravelUser {
	private int travelUserId;
	private int repayId;
	private String userName;
	private String userJob;
	
	@Id
	@Column(name = "travelUserId")
	public int getTravelUserId() {
		return travelUserId;
	}
	public void setTravelUserId(int travelUserId) {
		this.travelUserId = travelUserId;
	}
	
	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "userJob")
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	
	@Column(name = "repayId")
	public int getRepayId() {
		return repayId;
	}
	public void setRepayId(int repayId) {
		this.repayId = repayId;
	}
}
