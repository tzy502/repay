package serviceI;

import java.util.Date;
import java.util.List;

import model.BeanBudget;
import util.BaseException;

public interface IBudgetService {
	public void addBudget( int budgetId,String projectName,String projectType,String projectTypeId,String field,String fieldId,
			String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum,
			String projectId, float officeFees, float mailFees, float consultFees, float enterainFees,
			float advertiseFees, float bookFees, float printFees, float trafficFees, float fuelFees,
			float tollsFees, float carRepairFees, float insuranceFees, float meetFees, float trainingFees,
			float assetFees, float sportFees, float dailyFees, float materialFees, float repairFees,
			float laborFees, float otherFees)throws BaseException;
	public void modifryBudget(int budgetId,String projectName,String projectType,String projectTypeId,String field,String fieldId,
			String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum,
			String projectId, float officeFees, float mailFees, float consultFees, float enterainFees,
			float advertiseFees, float bookFees, float printFees, float trafficFees, float fuelFees,
			float tollsFees, float carRepairFees, float insuranceFees, float meetFees, float trainingFees,
			float assetFees, float sportFees, float dailyFees, float materialFees, float repairFees,
			float laborFees, float otherFees)throws BaseException;
	public BeanBudget searchBudget(int budgetId)throws BaseException;
	public List<BeanBudget> loadBudget() throws BaseException;
	public void delBudget(int budgetId)throws BaseException;
}
