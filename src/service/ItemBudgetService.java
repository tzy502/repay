package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ItemBudgetDao;
import model.BeanItemBudget;
import serviceI.IItemBudgetService;
import util.BaseException;
@Service
public class ItemBudgetService implements IItemBudgetService {
	@Resource
	private ItemBudgetDao ibd;
	@Override
	public void addItemBudget(int budgetId, String itemName, int oItemId, float itemBudgetCost) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=new BeanItemBudget();
		bit.setBudgetId(budgetId);
		bit.setItemName(itemName);
		bit.setoItemId(oItemId);
		bit.setItemBudgetCost(itemBudgetCost);
		ibd.additembudget(bit);
	}

	@Override
	public void modifryItemBudget(int itemBudgetId,  float itemBudgetCost ) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=ibd.Searchitembudget(itemBudgetId);
		bit.setItemBudgetCost(itemBudgetCost);
		ibd.modifryitembudget(bit);
	}

	@Override
	public void DelItemBudget(int itemBudgetId) throws BaseException {
		// TODO Auto-generated method stub
		ibd.Delitembudget(SearchItemBudget(itemBudgetId));
	}

	@Override
	public BeanItemBudget SearchItemBudget(int itemBudgetId) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=new BeanItemBudget();
		bit=null;
		bit=ibd.Searchitembudget(itemBudgetId);
		if(bit==null){
			throw new BaseException("查无数据");
		}
		
		return null;
	}

	@Override
	public List<BeanItemBudget> LoadItemBudget() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanItemBudget> result =new ArrayList<BeanItemBudget>();
		result=ibd.loaditembudget();
		return result;
	}

	@Override
	public List<BeanItemBudget> SearchItemBudgetbybudgetid(int budgetid) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanItemBudget> result =new ArrayList<BeanItemBudget>();
		result=ibd.Searchitembudgetbybudgetid(budgetid);
		return result;
	
	}

}
