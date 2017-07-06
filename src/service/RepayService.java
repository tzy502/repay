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
	RepayDao rd=new RepayDao();
	@Resource
	
	@Override
	public void addRepay(String workerId, String company, String projectId, String reason, int annex,
			String annexPath, float checkDays, float checkPlane, float checkTrain, float checkTOther, float checkStay,
			float checkFood, float checkMi, float checkOther, float sum, String approvalId, String data,String applicationId)throws BaseException {
		// TODO Auto-generated method stub
		BeanRepay br=new BeanRepay();
		br.setRepayId(rd.repaymaxId());
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
			String applicationId)throws BaseException {
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
	public void delRepay(int repayId)throws BaseException {
		// TODO Auto-generated method stub
		rd.DelRepay(rd.SearchRepay(repayId));
	}

	@Override
	public BeanRepay SearchRepay(int repayId) throws BaseException {
		// TODO Auto-generated method stub
		BeanRepay result =new BeanRepay();
		result =null;
		result =rd.SearchRepay(repayId);
		if(result==null){
			throw new BaseException("查无数据");
		}
		return result;
	}

	@Override
	public List<BeanRepay> loadAllRepay()throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanRepay> result =new ArrayList<BeanRepay>();
		 result = rd.loadAllRepay();
		return null;
	}

}
