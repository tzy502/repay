package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schoolitem")
public class BeanSchoolItem {
	private int schoolItemId;
	private int itemId;
	private String schoolItemName;
	
	@Id
	@Column(name = "schoolItemId")
	public int getSchoolItemId() {
		return schoolItemId;
	}
	public void setSchoolItemId(int schoolItemId) {
		this.schoolItemId = schoolItemId;
	}
	
	@Column(name = "itemId")
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "schoolItemName")
	public String getSchoolItemName() {
		return schoolItemName;
	}
	public void setSchoolItemName(String schoolItemName) {
		this.schoolItemName = schoolItemName;
	}
	
}
