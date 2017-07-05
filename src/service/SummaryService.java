package service;

import java.util.List;

import model.BeanSummary;
import serviceI.ISummaryService;
import util.BaseException;

public class SummaryService implements ISummaryService {

	@Override
	public void addSummary(int budgetId, String userId, String company, String projectId, int annex, float sum,
			String manager, String applicationId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifrySummary(int summaryId, int budgetId, String userId, String company, String projectId, int annex,
			float sum, String manager, String applicationId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSummary(int summaryId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanSummary searchSummary(int summaryId) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanSummary> loadSummary() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
