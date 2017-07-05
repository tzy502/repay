package serviceI;

import java.util.Date;
import java.util.List;

import model.BeanBudget;
import util.BaseException;

public interface IBudgetService {
	public void addBudget(  String projectName, String projectType, String projectTypeId, String field
			,String fieldId,String source, String sourceId, Date prostartDate, Date proendDate,
			float budgetSum, String projectId)throws BaseException;
	public void modifryBudget( int budgetId, String projectName, String projectType, String projectTypeId, String field
			,String fieldId,String source, String sourceId, Date prostartDate, Date proendDate,
			float budgetSum, String projectId)throws BaseException;
	public void DelBudget(int budgetId)throws BaseException;
	public BeanBudget SearchBudget(int budgetId)throws BaseException;
	public List<BeanBudget> LoadBudget()throws BaseException;	
}
