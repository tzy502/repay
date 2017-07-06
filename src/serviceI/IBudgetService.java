package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanBudget;
import util.BaseException;
@Component
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
