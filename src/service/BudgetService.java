package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BudgetDao;
import model.BeanBudget;
import serviceI.IBudgetService;
import util.BaseException;

public class BudgetService implements IBudgetService {
	BudgetDao bd=new BudgetDao();
	@Override
	public void addBudget(int budgetId, String projectName, String projectType, String projectTypeId, String field,
			String fieldId, String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum,
			String projectId, float officeFees, float mailFees, float consultFees, float enterainFees,
			float advertiseFees, float bookFees, float printFees, float trafficFees, float fuelFees, float tollsFees,
			float carRepairFees, float insuranceFees, float meetFees, float trainingFees, float assetFees,
			float sportFees, float dailyFees, float materialFees, float repairFees, float laborFees, float otherFees) {
		// TODO Auto-generated method stub
		BeanBudget budget=new BeanBudget();
		budget.setBudgetId(budgetId);
		budget.setProjectName(projectName);
		budget.setProjectType(projectType);
		budget.setProjectTypeId(projectTypeId);
		budget.setField(field);
		budget.setFieldId(fieldId);
		budget.setSource(source);
		budget.setSourceId(sourceId);
		budget.setProstartDate(prostartDate);
		budget.setProendDate(proendDate);
		budget.setBudgetSum(budgetSum);
		budget.setProjectId(projectId);
		budget.setOfficeFees(officeFees);
		budget.setMailFees(mailFees);
		budget.setConsultFees(consultFees);
		budget.setEnterainFees(enterainFees);
		budget.setAdvertiseFees(advertiseFees);
		budget.setBookFees(bookFees);
		budget.setPrintFees(printFees);
		budget.setTrafficFees(trafficFees);
		budget.setFuelFees(fuelFees);
		budget.setTollsFees(tollsFees);
		budget.setCarRepairFees(carRepairFees);
		budget.setInsuranceFees(insuranceFees);
		budget.setMeetFees(meetFees);
		budget.setTrainingFees(trainingFees);
		budget.setAssetFees(assetFees);
		budget.setSportFees(sportFees);
		budget.setDailyFees(dailyFees);
		budget.setMaterialFees(materialFees);
		budget.setRepairFees(repairFees);
		budget.setLaborFees(laborFees);
		budget.setOtherFees(otherFees);
		bd.addbudget(budget);
		
	}

	@Override
	public void modifryBudget(int budgetId, String projectName, String projectType, String projectTypeId, String field,
			String fieldId, String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum,
			String projectId, float officeFees, float mailFees, float consultFees, float enterainFees,
			float advertiseFees, float bookFees, float printFees, float trafficFees, float fuelFees, float tollsFees,
			float carRepairFees, float insuranceFees, float meetFees, float trainingFees, float assetFees,
			float sportFees, float dailyFees, float materialFees, float repairFees, float laborFees, float otherFees) {
		// TODO Auto-generated method stub
		BeanBudget budget=new BeanBudget();
		budget.setBudgetId(budgetId);
		budget.setProjectName(projectName);
		budget.setProjectType(projectType);
		budget.setProjectTypeId(projectTypeId);
		budget.setField(field);
		budget.setFieldId(fieldId);
		budget.setSource(source);
		budget.setSourceId(sourceId);
		budget.setProstartDate(prostartDate);
		budget.setProendDate(proendDate);
		budget.setBudgetSum(budgetSum);
		budget.setProjectId(projectId);
		budget.setOfficeFees(officeFees);
		budget.setMailFees(mailFees);
		budget.setConsultFees(consultFees);
		budget.setEnterainFees(enterainFees);
		budget.setAdvertiseFees(advertiseFees);
		budget.setBookFees(bookFees);
		budget.setPrintFees(printFees);
		budget.setTrafficFees(trafficFees);
		budget.setFuelFees(fuelFees);
		budget.setTollsFees(tollsFees);
		budget.setCarRepairFees(carRepairFees);
		budget.setInsuranceFees(insuranceFees);
		budget.setMeetFees(meetFees);
		budget.setTrainingFees(trainingFees);
		budget.setAssetFees(assetFees);
		budget.setSportFees(sportFees);
		budget.setDailyFees(dailyFees);
		budget.setMaterialFees(materialFees);
		budget.setRepairFees(repairFees);
		budget.setLaborFees(laborFees);
		budget.setOtherFees(otherFees);
		bd.modifrybudget(budget);
	}

	@Override
	public BeanBudget searchBudget(int budgetId) {
		BeanBudget budget=new BeanBudget();
		budget=null;
		budget=bd.Searchbudget(budgetId);
		return budget;

	}

	@Override
	public void delBudget(int budgetId)throws BaseException {
		BeanBudget budget=bd.Searchbudget(budgetId);
		if(budget==null){
			throw new BaseException("密码错误！");
		}
		else{
			bd.Delbudget(budget);
		}
		
	}

	@Override
	public List<BeanBudget> loadBudget() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanBudget> result =new ArrayList<BeanBudget>();
		result=bd.loadAllbudget();
		return result;
	}

}
