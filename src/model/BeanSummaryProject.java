package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summaryproject")
public class BeanSummaryProject {
	private int summaryprjectid;
	private String summaryprjectname;
	@Id
	@Column(name = "summaryprjectid")
	public int getSummaryprjectid() {
		return summaryprjectid;
	}
	public void setSummaryprjectid(int summaryprjectid) {
		this.summaryprjectid = summaryprjectid;
	}
	@Column(name = "summaryprjectname")
	public String getSummaryprjectname() {
		return summaryprjectname;
	}
	public void setSummaryprjectname(String summaryprjectname) {
		this.summaryprjectname = summaryprjectname;
	}
	
}
