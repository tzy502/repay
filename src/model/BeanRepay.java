package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repay")
public class BeanRepay {
	private int repayId;
	private String company;
	private String projectId;
	private String reason;
	private int annex;
	private String annexPath;
	private float checkDays;
	private float checkPlane;
	private float checkTrain;
	private float checkTOther;
	private float checkStay;
	private float checkFood;
	private float checkMi;
	private float checkOther;
	private float sum;
	private String approvalId;
	private String data;
	private String applicationId;
	private String workerId;
	private String userName;
	private float money;
	private String cardNumber;
	private String auditor;
	
	@Id
	@Column(name = "repayId")
	public int getRepayId() {
		return repayId;
	}
	public void setRepayId(int repayId) {
		this.repayId = repayId;
	}
	
	@Column(name = "workerId")
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	
	@Column(name = "company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "projectId")
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Column(name = "reason")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(name = "annex")
	public int getAnnex() {
		return annex;
	}
	public void setAnnex(int annex) {
		this.annex = annex;
	}
	
	@Column(name = "annexPath")
	public String getAnnexPath() {
		return annexPath;
	}
	public void setAnnexPath(String annexPath) {
		this.annexPath = annexPath;
	}
	
	@Column(name = "checkDays")
	public float getCheckDays() {
		return checkDays;
	}
	public void setCheckDays(float checkDays) {
		this.checkDays = checkDays;
	}
	
	@Column(name = "checkPlane")
	public float getCheckPlane() {
		return checkPlane;
	}
	public void setCheckPlane(float checkPlane) {
		this.checkPlane = checkPlane;
	}
	
	@Column(name = "checkTrain")
	public float getCheckTrain() {
		return checkTrain;
	}
	public void setCheckTrain(float checkTrain) {
		this.checkTrain = checkTrain;
	}
	
	@Column(name = "checkTOther")
	public float getCheckTOther() {
		return checkTOther;
	}
	public void setCheckTOther(float checkTOther) {
		this.checkTOther = checkTOther;
	}
	
	@Column(name = "checkStay")
	public float getCheckStay() {
		return checkStay;
	}
	public void setCheckStay(float checkStay) {
		this.checkStay = checkStay;
	}
	
	@Column(name = "checkFood")
	public float getCheckFood() {
		return checkFood;
	}
	public void setCheckFood(float checkFood) {
		this.checkFood = checkFood;
	}
	
	@Column(name = "checkMi")
	public float getCheckMi() {
		return checkMi;
	}
	public void setCheckMi(float checkMi) {
		this.checkMi = checkMi;
	}
	
	@Column(name = "checkOther")
	public float getCheckOther() {
		return checkOther;
	}
	public void setCheckOther(float checkOther) {
		this.checkOther = checkOther;
	}
	
	@Column(name = "sum")
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	
	@Column(name = "approvalId")
	public String getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}
	
	@Column(name = "data")
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Column(name = "applicationId")
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	@Column(name = "auditor")
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	
	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "money")
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	@Column(name = "cardNumber")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
