package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget")
public class BeanBudget {
	private int budgetId;
	private String projectName;
	private String projectType;
	private String projectTypeId;
	private String field;
	private String fieldId;
	private String source;
	private String sourceId;
	private Date prostartDate;
	private Date proendDate;
	private float budgetSum;
	private String projectId;
	

	@Id
	@Column(name = "budgetId")
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}
	
	@Column(name = "projectName")
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Column(name = "projectType")
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	@Column(name = "projectTypeId")
	public String getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	
	@Column(name = "field")
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	@Column(name = "fieldId")
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	
	@Column(name = "source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name = "sourceId")
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
	@Column(name = "prostartDate")
	public Date getProstartDate() {
		return prostartDate;
	}
	public void setProstartDate(Date prostartDate) {
		this.prostartDate = prostartDate;
	}
	
	@Column(name = "proendDate")
	public Date getProendDate() {
		return proendDate;
	}
	public void setProendDate(Date proendDate) {
		this.proendDate = proendDate;
	}
	
	@Column(name = "budgetSum")
	public float getBudgetSum() {
		return budgetSum;
	}
	public void setBudgetSum(float budgetSum) {
		this.budgetSum = budgetSum;
	}
	
	@Column(name = "projectId")
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

}
