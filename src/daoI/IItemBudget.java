package daoI;

import java.util.List;

import model.BeanItemBudget;

public interface IItemBudget {
	public void additembudget(BeanItemBudget itembudget);

	public BeanItemBudget Searchitembudget(int itembudgetId);

	public List<BeanItemBudget> loaditembudget(int itembudgetId);

	public List<BeanItemBudget> loadAllitembudgetbybudgetid();

	public void modifryitembudget(BeanItemBudget itembudget);

	public void Delitembudget(BeanItemBudget itembudget);

}
