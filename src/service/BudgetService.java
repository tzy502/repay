package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BudgetDao;
import model.BeanBudget;
import serviceI.IBudgetService;
import util.BaseException;
@Service
public class BudgetService implements IBudgetService {
	@Resource
	BudgetDao bd=new BudgetDao();
	@Override
	public void addBudget(int projectId, float budgetSum, float independentFees, float applyFees) throws BaseException {
		// TODO Auto-generated method stub
		BeanBudget bb=new BeanBudget();
		if(projectId==-1||independentFees==-1||applyFees==-1){
			throw new BaseException("有数据没有填 ");
		}
		bb.setProjectId(projectId);
		bb.setBudgetSum(budgetSum);
		bb.setIndependentFees(independentFees);
		bb.setApplyFees(applyFees);
		bd.addbudget(bb);
	}

	@Override
	public void modifryBudget(int budgetId, int projectId, float budgetSum, float independentFees, float applyFees)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanBudget bb=new BeanBudget();
		bb.setBudgetId(budgetId);
		bb.setProjectId(projectId);
		bb.setBudgetSum(budgetSum);
		bb.setIndependentFees(independentFees);
		bb.setApplyFees(applyFees);
		bd.modifrybudget(bb);

	}

	@Override
	public void DelBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub
		bd.Delbudget(SearchBudget(budgetId));
	}

	@Override
	public BeanBudget SearchBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub
		BeanBudget bb=new BeanBudget();
		bb=null;
		bb=bd.Searchbudget(budgetId);
		if (bb==null){
			throw new BaseException("查无数据");
		}
		
		return bb;
	}

	@Override
	public List<BeanBudget> LoadBudget() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanBudget> result =new ArrayList<BeanBudget>();
		result=null;
		result=bd.loadAllbudget();
		return result;
	}

	@Override
	public int SearchmaxId(int projectId, float budgetSum, float independentFees, float applyFees) throws BaseException {
		// TODO Auto-generated method stub
		int result=-1;
		result=bd.SearchmaxId(projectId, budgetSum, independentFees, applyFees);
		if(result==-1){
			throw new BaseException("添加错误");
		}
		return result;
	}

}
