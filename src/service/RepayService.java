package service;

import java.util.ArrayList;
import java.util.List;

import dao.RepayDao;
import model.BeanRepay;
import serviceI.IRepayService;

public class RepayService implements IRepayService {
	RepayDao rd=new RepayDao();
	@Override
	public void addRepay(int repayId, String workerId, String company, String projectId, String reason, int annex,
			String annexPath, float checkDays, float checkPlane, float checkTrain, float checkTOther, float checkStay,
			float checkFood, float checkMi, float checkOther, float sum, String approvalId, String data,String applicationId) {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay();
		br.setRepayId(repayId);
		br.setWorkerId(workerId);
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
		rd.addRepay(br);
		
	}

	@Override
	public void mordifyRepay(int repayId, String workerId, String company, String projectId, String reason, int annex,
			String annexPath, float checkDays, float checkPlane, float checkTrain, float checkTOther, float checkStay,
			float checkFood, float checkMi, float checkOther, float sum, String approvalId, String data,
			String applicationId) {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay();
		br.setRepayId(repayId);
		br.setWorkerId(workerId);
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
		rd.modifryRepay(br);
	}

	@Override
	public void delRepay(int repayId) {
		// TODO Auto-generated method stub
		rd.DelRepay(rd.SearchRepay(repayId));
	}

	@Override
	public BeanRepay SearchRepay(int repayId) {
		// TODO Auto-generated method stub
		BeanRepay result =new BeanRepay();
		result =rd.SearchRepay(repayId);
		return result;
	}

	@Override
	public List<BeanRepay> loadAllRepay() {
		// TODO Auto-generated method stub
		 List<BeanRepay> result =new ArrayList<BeanRepay>();
		 result = rd.loadAllRepay();
		return null;
	}

}
