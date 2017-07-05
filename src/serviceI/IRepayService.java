package serviceI;

import java.util.List;

import model.BeanRepay;

public interface IRepayService {
	public void addRepay(int repayId, String workerId, String company, String projectId, String reason, int annex, String annexPath, 
			float checkDays,float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood, float checkMi, 
			float checkOther,float sum, String approvalId, String data, String applicationId);
	public void mordifyRepay(int repayId, String workerId, String company, String projectId, String reason, int annex, String annexPath, 
			float checkDays,float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood, float checkMi, 
			float checkOther,float sum, String approvalId, String data, String applicationId);
	public void delRepay(int repayId);
	public BeanRepay SearchRepay(int repayId);
	public List<BeanRepay> loadAllRepay();
}
