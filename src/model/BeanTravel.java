package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travel")
public class BeanTravel {
	private int travelId;
	private int repayId;
	private String travelLocation;
	private String travelProvince;
	private Date  startData; 
	private Date endData;
	private int days;
	private float plane;
	private float train;
	private float tasfficOther;
	private float stayFees;
	private float foodFees;
	private float miFess;
	private float other ;
	
	@Id
	@Column(name = "travelId")
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	
	@Column(name = "repayId")
	public int getRepayId() {
		return repayId;
	}
	public void setRepayId(int repayId) {
		this.repayId = repayId;
	}
	
	@Column(name = "travelLocation")
	public String getTravelLocation() {
		return travelLocation;
	}
	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
	}
	
	@Column(name = "travelProvince")
	public String getTravelProvince() {
		return travelProvince;
	}
	public void setTravelProvince(String travelProvince) {
		this.travelProvince = travelProvince;
	}
	
	@Column(name = "startData")
	public Date getStartData() {
		return startData;
	}
	public void setStartData(Date startData) {
		this.startData = startData;
	}
	
	@Column(name = "endData")
	public Date getEndData() {
		return endData;
	}
	public void setEndData(Date endData) {
		this.endData = endData;
	}
	
	@Column(name = "days")
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	@Column(name = "plane")
	public float getPlane() {
		return plane;
	}
	public void setPlane(float plane) {
		this.plane = plane;
	}
	
	@Column(name = "train")
	public float getTrain() {
		return train;
	}
	public void setTrain(float train) {
		this.train = train;
	}
	
	@Column(name = "tasfficOther")
	public float getTasfficOther() {
		return tasfficOther;
	}
	public void setTasfficOther(float tasfficOther) {
		this.tasfficOther = tasfficOther;
	}
	
	@Column(name = "stayFees")
	public float getStayFees() {
		return stayFees;
	}
	public void setStayFees(float stayFees) {
		this.stayFees = stayFees;
	}
	
	@Column(name = "foodFees")
	public float getFoodFees() {
		return foodFees;
	}
	public void setFoodFees(float foodFees) {
		this.foodFees = foodFees;
	}
	
	@Column(name = "miFess")
	public float getMiFess() {
		return miFess;
	}
	public void setMiFess(float miFess) {
		this.miFess = miFess;
	}
	
	@Column(name = "other")
	public float getOther() {
		return other;
	}
	public void setOther(float other) {
		this.other = other;
	}
	
}
