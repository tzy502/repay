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
	private float officeFees;
	private float mailFees;
	private float consultFees;
	private float enterainFees;
	private float advertiseFees;
	private float bookFees;
	private float printFees;
	private float trafficFees;
	private float fuelFees;
	private float tollsFees;
	private float carRepairFees;
	private float insuranceFees;
	private float meetFees;
	private float trainingFees;
	private float assetFees;
	private float sportFees;
	private float dailyFees;
	private float materialFees;
	private float repairFees;
	private float laborFees;
	private float otherFees;

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
	
	@Column(name = "officeFees")
	public float getOfficeFees() {
		return officeFees;
	}
	public void setOfficeFees(float officeFees) {
		this.officeFees = officeFees;
	}
	
	@Column(name = "mailFees")
	public float getMailFees() {
		return mailFees;
	}
	public void setMailFees(float mailFees) {
		this.mailFees = mailFees;
	}
	
	@Column(name = "consultFees")
	public float getConsultFees() {
		return consultFees;
	}
	public void setConsultFees(float consultFees) {
		this.consultFees = consultFees;
	}
	
	@Column(name = "enterainFees")
	public float getEnterainFees() {
		return enterainFees;
	}
	public void setEnterainFees(float enterainFees) {
		this.enterainFees = enterainFees;
	}
	
	@Column(name = "advertiseFees")
	public float getAdvertiseFees() {
		return advertiseFees;
	}
	public void setAdvertiseFees(float advertiseFees) {
		this.advertiseFees = advertiseFees;
	}
	
	@Column(name = "bookFees")
	public float getBookFees() {
		return bookFees;
	}
	public void setBookFees(float bookFees) {
		this.bookFees = bookFees;
	}
	
	@Column(name = "printFees")
	public float getPrintFees() {
		return printFees;
	}
	public void setPrintFees(float printFees) {
		this.printFees = printFees;
	}
	
	@Column(name = "trafficFees")
	public float getTrafficFees() {
		return trafficFees;
	}
	public void setTrafficFees(float trafficFees) {
		this.trafficFees = trafficFees;
	}
	
	@Column(name = "fuelFees")
	public float getFuelFees() {
		return fuelFees;
	}
	public void setFuelFees(float fuelFees) {
		this.fuelFees = fuelFees;
	}
	
	@Column(name = "tollsFees")
	public float getTollsFees() {
		return tollsFees;
	}
	public void setTollsFees(float tollsFees) {
		this.tollsFees = tollsFees;
	}
	
	@Column(name = "carRepairFees")
	public float getCarRepairFees() {
		return carRepairFees;
	}
	public void setCarRepairFees(float carRepairFees) {
		this.carRepairFees = carRepairFees;
	}
	
	@Column(name = "insuranceFees")
	public float getInsuranceFees() {
		return insuranceFees;
	}
	public void setInsuranceFees(float insuranceFees) {
		this.insuranceFees = insuranceFees;
	}
	
	@Column(name = "meetFees")
	public float getMeetFees() {
		return meetFees;
	}
	public void setMeetFees(float meetFees) {
		this.meetFees = meetFees;
	}
	
	@Column(name = "trainingFees")
	public float getTrainingFees() {
		return trainingFees;
	}
	public void setTrainingFees(float trainingFees) {
		this.trainingFees = trainingFees;
	}
	
	@Column(name = "assetFees")
	public float getAssetFees() {
		return assetFees;
	}
	public void setAssetFees(float assetFees) {
		this.assetFees = assetFees;
	}
	
	@Column(name = "sportFees")
	public float getSportFees() {
		return sportFees;
	}
	public void setSportFees(float sportFees) {
		this.sportFees = sportFees;
	}
	
	@Column(name = "dailyFees")
	public float getDailyFees() {
		return dailyFees;
	}
	public void setDailyFees(float dailyFees) {
		this.dailyFees = dailyFees;
	}
	
	@Column(name = "materialFees")
	public float getMaterialFees() {
		return materialFees;
	}
	public void setMaterialFees(float materialFees) {
		this.materialFees = materialFees;
	}
	
	@Column(name = "repairFees")
	public float getRepairFees() {
		return repairFees;
	}
	public void setRepairFees(float repairFees) {
		this.repairFees = repairFees;
	}
	
	@Column(name = "laborFees")
	public float getLaborFees() {
		return laborFees;
	}
	public void setLaborFees(float laborFees) {
		this.laborFees = laborFees;
	}
	
	@Column(name = "otherFees")
	public float getOtherFees() {
		return otherFees;
	}
	public void setOtherFees(float otherFees) {
		this.otherFees = otherFees;
	}
}
