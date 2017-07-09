package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BudgetDao;
import daoI.IBudgetDao;
import model.BeanBudget;
import serviceI.IBudgetService;
import util.BaseException;
@Service
public class BudgetService implements IBudgetService {
	@Resource
	private IBudgetDao IBudgetDao;
	
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
		IBudgetDao.addbudget(bb);
	}

	@Override
	public void modifryBudget(int budgetId, float budgetSum, float independentFees, float applyFees)
			throws BaseException {
		// TODO Auto-generated method stub
		
		BeanBudget bb=IBudgetDao.Searchbudget(budgetId);
		bb.setBudgetSum(budgetSum);
		bb.setIndependentFees(independentFees);
		bb.setApplyFees(applyFees);
		IBudgetDao.modifrybudget(bb);

	}

	@Override
	public void DelBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub
		IBudgetDao.Delbudget(SearchBudget(budgetId));
	}

	@Override
	public BeanBudget SearchBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub
		BeanBudget bb=new BeanBudget();
		bb=null;
		bb=IBudgetDao.Searchbudget(budgetId);
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
		result=IBudgetDao.loadAllbudget();
		return result;
	}

	@Override
	public int SearchmaxId(int projectId, float budgetSum, float independentFees, float applyFees) throws BaseException {
		// TODO Auto-generated method stub
		int result=-1;
		result=IBudgetDao.SearchmaxId(projectId, budgetSum, independentFees, applyFees);
		if(result==-1){
			throw new BaseException("添加错误");
		}
		return result;
	}

	@Override
	public BeanBudget searchBudgetByPId(int projectId) throws BaseException {
		// TODO 自动生成的方法存根
		BeanBudget bb=new BeanBudget();
		bb=null;
		bb=IBudgetDao.SearchbudgetByPId(projectId);
		if (bb==null){
			throw new BaseException("查无数据");
		}
		return bb;
	}

}
