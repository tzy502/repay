package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itembudget")
public class BeanItemBudget {
	private int itemBudgetId;
	private int budgetId;
	private String itemName;
	private float itemBudgetCost;
	
	@Id
	@Column(name = "itemBudgetId")
	public int getItemBudgetId() {
		return itemBudgetId;
	}
	public void setItemBudgetId(int itemBudgetId) {
		this.itemBudgetId = itemBudgetId;
	}
	
	@Column(name = "budgetId")
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}
	
	@Column(name = "itemBudgetCost")
	public float getItemBudgetCost() {
		return itemBudgetCost;
	}
	public void setItemBudgetCost(float itemBudgetCost) {
		this.itemBudgetCost = itemBudgetCost;
	}
	@Column(name = "itemName")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
