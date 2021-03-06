package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanItemBudget;
import util.BaseException;
@Component
public interface IItemBudgetService {
	public void addItemBudget( int budgetId, String itemName, int oItemId, float itemBudgetCost)throws BaseException;
	
	public void modifryItemBudget(int itemBudgetId, float itemBudgetCost)throws BaseException;
	
	public void DelItemBudget(int itemBudgetId)throws BaseException;
	
	public BeanItemBudget SearchItemBudget(int itemBudgetId)throws BaseException;
	
	public List<BeanItemBudget> LoadItemBudget()throws BaseException;
	
	public List<BeanItemBudget> SearchItemBudgetbybudgetid(int budgetid)throws BaseException;
}
