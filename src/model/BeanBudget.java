package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget")
public class BeanBudget {
	private int budgetId;
	private int projectId;
	private float budgetSum;
	private float independentFees;
	private float applyFees;

	@Id
	@Column(name = "budgetId")
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}
	
	@Column(name = "projectId")
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	@Column(name = "budgetSum")
	public float getBudgetSum() {
		return budgetSum;
	}
	public void setBudgetSum(float budgetSum) {
		this.budgetSum = budgetSum;
	}
	
	@Column(name = "independentFees")
	public float getIndependentFees() {
		return independentFees;
	}
	public void setIndependentFees(float independentFees) {
		this.independentFees = independentFees;
	}
	
	@Column(name = "applyFees")
	public float getApplyFees() {
		return applyFees;
	}
	public void setApplyFees(float applyFees) {
		this.applyFees = applyFees;
	}
	
	

}
