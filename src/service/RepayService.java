package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.RepayDao;
import model.BeanRepay;
import serviceI.IRepayService;
import util.BaseException;
@Service
public class RepayService implements IRepayService {
	@Resource
	RepayDao rd=new RepayDao();
	@Override
	public void addRepay(String company, String projectId, String reason, int annex, String annexPath, float checkDays,
			float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood, float checkMi,
			float checkOther, float sum, String approvalId, String data, String applicationId, String workerId,
			String userName, float money, String cardNumber, String auditor) throws BaseException {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay();
		br.setCompany(company);
		br.setProjectId(projectId);
		br.setReason(reason);
		br.setAnnex(annex);
		br.setAnnexPath(annexPath);
		br.setCheckDays(checkDays);
		br.setCheckPlane(checkPlane);
		br.setCheckTrain(checkTrain);
		br.setCheckTOther(checkTOther);
		br.setCheckStay(checkStay);
		br.setCheckFood(checkFood);
		br.setCheckMi(checkMi);
		br.setCheckOther(checkOther);
		br.setSum(sum);
		br.setApprovalId(approvalId);
		br.setData(data);
		br.setApplicationId(applicationId);
		br.setWorkerId(workerId);
		br.setUserName(userName);
		br.setMoney(money);
		br.setCardNumber(cardNumber);
		br.setAuditor(auditor);
		rd.addRepay(br);
		
	}

	@Override
	public void mordifyRepay(int repayId, String company, String projectId, String reason, int annex, String annexPath,
			float checkDays, float checkPlane, float checkTrain, float checkTOther, float checkStay, float checkFood,
			float checkMi, float checkOther, float sum, String approvalId, String data, String applicationId,
			String workerId, String userName, float money, String cardNumber, String auditor) throws BaseException {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay();
		br.setRepayId(repayId);
		br.setCompany(company);
		br.setProjectId(projectId);
		br.setReason(reason);
		br.setAnnex(annex);
		br.setAnnexPath(annexPath);
		br.setCheckDays(checkDays);
		br.setCheckPlane(checkPlane);
		br.setCheckTrain(checkTrain);
		br.setCheckTOther(checkTOther);
		br.setCheckStay(checkStay);
		br.setCheckFood(checkFood);
		br.setCheckMi(checkMi);
		br.setCheckOther(checkOther);
		br.setSum(sum);
		br.setApprovalId(approvalId);
		br.setData(data);
		br.setApplicationId(applicationId);
		br.setWorkerId(workerId);
		br.setUserName(userName);
		br.setMoney(money);
		br.setCardNumber(cardNumber);
		br.setAuditor(auditor);
		rd.modifryRepay(br);
	}

	@Override
	public void delRepay(int repayId) throws BaseException {
		// TODO Auto-generated method stub
		rd.DelRepay(SearchRepay(repayId));
	}

	@Override
	public BeanRepay SearchRepay(int repayId) throws BaseException {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay(); 
		br=null;
		br=rd.SearchRepay(repayId);
		if(br==null){
			throw new BaseException("查无数据");
		}
		return br;
	}

	@Override
	public List<BeanRepay> loadAllRepay() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanRepay> result =new ArrayList<BeanRepay>();
		result =rd.loadAllRepay();
		return result;
	}

	@Override
	public int SearchRepaymax() throws BaseException {
		// TODO Auto-generated method stub
		return rd.repaymaxId();
	}

}
