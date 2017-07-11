package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemcost")
public class BeanItemCost {
	private int itemCostId;
	private int summaryId;//+id
	private int oItemId;//
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
	
	@Column(name = "summaryId")
	public int getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(int summaryId) {
		this.summaryId = summaryId;
	}
	
	@Column(name = "oItemId")
	public int getoItemId() {
		return oItemId;
	}
	public void setoItemId(int oItemId) {
		this.oItemId = oItemId;
	}
}
