package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class BeanTravelUser {
	private int travelUserId;
	private String travelId;
	private String userId;
	
	@Id
	@Column(name = "travelUserId")
	public int getTravelUserId() {
		return travelUserId;
	}
	public void setTravelUserId(int travelUserId) {
		this.travelUserId = travelUserId;
	}
	
	@Column(name = "travelId")
	public String getTravelId() {
		return travelId;
	}
	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}
	
	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
