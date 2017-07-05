package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traveluser")
public class BeanTravelUser {
	private int travelUserId;
	private String repayId;
	private String userId;
	
	@Id
	@Column(name = "travelUserId")
	public int getTravelUserId() {
		return travelUserId;
	}
	public void setTravelUserId(int travelUserId) {
		this.travelUserId = travelUserId;
	}
	
	@Column(name = "repayId")
	public String getTravelId() {
		return repayId;
	}
	public void setTravelId(String repayId) {
		this.repayId = repayId;
	}
	
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
