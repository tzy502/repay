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
	private int itemId;
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
	
	@Column(name = "itemId")
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "itemBudgetCost")
	public float getItemBudgetCost() {
		return itemBudgetCost;
	}
	public void setItemBudgetCost(float itemBudgetCost) {
		this.itemBudgetCost = itemBudgetCost;
	}
}
