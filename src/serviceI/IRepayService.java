package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanRepay;
import util.BaseException;
@Component
public interface IRepayService {
	public void addRepay( String workerId, String company, String projectId, String reason, int annex, String annexPath, 
			float checkDays,float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood, float checkMi, 
			float checkOther,float sum, String approvalId, String data, String applicationId)throws BaseException;
	public void mordifyRepay(int repayId, String workerId, String company, String projectId, String reason, int annex, String annexPath, 
			float checkDays,float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood, float checkMi, 
			float checkOther,float sum, String approvalId, String data, String applicationId)throws BaseException;
	public void delRepay(int repayId)throws BaseException;
	public BeanRepay SearchRepay(int repayId)throws BaseException;
	public List<BeanRepay> loadAllRepay()throws BaseException;
}
