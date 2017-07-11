package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.SummaryDao;
import model.BeanSummary;
import serviceI.ISummaryService;
import util.BaseException;
@Service
public class SummaryService implements ISummaryService {
	@Resource
	SummaryDao sd=new SummaryDao();
	@Override
	public void addSummary(String userId, String company, String projectId, int billCount, float sum, String workerId,
			String userName, float money, String cardNumber, String manager, String applicationId)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanSummary bs=new BeanSummary();
		bs.setUserId(userId);
		bs.setCompany(company);
		bs.setProjectId(projectId);
		bs.setBillCount(billCount);
		bs.setSum(sum);
		bs.setWorkerId(workerId);
		bs.setUserName(userName);
		bs.setMoney(money);
		bs.setCardNumber(cardNumber);
		bs.setManager(manager);
		bs.setApplicationId(applicationId);
		sd.addSummary(bs);
	}

	@Override
	public void modifrySummary(int summaryId, String userId, String company, String projectId, int billCount, float sum,
			String workerId, String userName, float money, String cardNumber, String manager, String applicationId)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanSummary bs=new BeanSummary();
		bs.setUserId(userId);
		bs.setCompany(company);
		bs.setProjectId(projectId);
		bs.setBillCount(billCount);
		bs.setSum(sum);
		bs.setWorkerId(workerId);
		bs.setUserName(userName);
		bs.setMoney(money);
		bs.setCardNumber(cardNumber);
		bs.setManager(manager);
		bs.setApplicationId(applicationId);
		bs.setSummaryId(summaryId);
		sd.modifrySummary(bs);
	}

	@Override
	public void delSummary(int summaryId) throws BaseException {
		// TODO Auto-generated method stub
		sd.DelSummary(searchSummary(summaryId));
	}

	@Override
	public BeanSummary searchSummary(int summaryId) throws BaseException {
		// TODO Auto-generated method stub
		BeanSummary bs=new BeanSummary();
		bs=null;
		bs=sd.SearchSummary(summaryId);
		if(bs==null){		
			throw new BaseException("查无数据");
		}
		return bs;
	}

	@Override
	public List<BeanSummary> loadSummary() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanSummary> result=new ArrayList<BeanSummary>();
		result=sd.loadAllSummary();
		return result;
	}

	@Override
	public int Searchmaxnuk(String userId ,String projectId) throws BaseException {
		// TODO Auto-generated method stub
		int result=1;
		result=sd.SearchSummaryid(userId, projectId);
		if(result==-1){
			throw new BaseException("添加错误");
		}
		return result;
	}

	@Override
	public List<BeanSummary> loadASummary() throws BaseException {
		// TODO 自动生成的方法存根
		List<BeanSummary> result=new ArrayList<BeanSummary>();
		result=sd.loadASummary();
		return result;
	}

}
