package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transterCard")
public class BeanTransterCard {
	
	private int transferCardId;
	private int repayId;
	private String transferCardFees;
	
	@Id
	@Column(name = "transferCardId")
	public int getTransferCardId() {
		return transferCardId;
	}
	public void setTransferCardId(int transferCardId) {
		this.transferCardId = transferCardId;
	}
	
	@Column(name = "repayId")
	public int getRepayId() {
		return repayId;
	}
	public void setRepayId(int repayId) {
		this.repayId = repayId;
	}
	
	@Column(name = "transferCardFees")
	public String getTransferCardFees() {
		return transferCardFees;
	}
	public void setTransferCardFees(String transferCardFees) {
		this.transferCardFees = transferCardFees;
	}
}
