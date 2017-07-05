package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summarymoney")
public class BeanSummaryMoney {
	private int key;
	private int summaryprojectid;
	private int summaryid;
	private float cost;
	@Id
	@Column(name = "key")
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	@Column(name = "summaryprojectid")
	public int getSummaryprojectid() {
		return summaryprojectid;
	}
	public void setSummaryprojectid(int summaryprojectid) {
		this.summaryprojectid = summaryprojectid;
	}
	@Column(name = "summaryid")
	public int getSummaryid() {
		return summaryid;
	}
	public void setSummaryid(int summaryid) {
		this.summaryid = summaryid;
	}
	@Column(name = "cost")
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
