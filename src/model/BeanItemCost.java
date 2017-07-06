package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemcost")
public class BeanItemCost {
	private int itemCostId;
	private int summary;
	private int schoolItemId;
	private String itemCostName;
	private float itemCost;
	
	@Id
	@Column(name = "itemCostId")
	public int getItemCostId() {
		return itemCostId;
	}
	public void setItemCostId(int itemCostId) {
		this.itemCostId = itemCostId;
	}
	
	@Column(name = "summary")
	public int getSummary() {
		return summary;
	}
	public void setSummary(int summary) {
		this.summary = summary;
	}
	
	@Column(name = "schoolItemId")
	public int getSchoolItemId() {
		return schoolItemId;
	}
	public void setSchoolItemId(int schoolItemId) {
		this.schoolItemId = schoolItemId;
	}
	
	@Column(name = "itemCostName")
	public String getItemCostName() {
		return itemCostName;
	}
	public void setItemCostName(String itemCostName) {
		this.itemCostName = itemCostName;
	}
	
	@Column(name = "itemCost")
	public float getItemCost() {
		return itemCost;
	}
	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}
}
