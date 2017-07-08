package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanBudget;
import util.BaseException;
@Component
public interface IBudgetService {
	public void addBudget(  int projectId, float budgetSum, float independentFees, float applyFees)throws BaseException;
	public void modifryBudget(int budgetId, int projectId, float budgetSum, float independentFees, float applyFees)throws BaseException;
	public void DelBudget(int budgetId)throws BaseException;
	public BeanBudget SearchBudget(int budgetId)throws BaseException;
	public List<BeanBudget> LoadBudget()throws BaseException;	
	public int SearchmaxId( int projectId,	 float budgetSum, float independentFees, float applyFees)throws BaseException;
}
