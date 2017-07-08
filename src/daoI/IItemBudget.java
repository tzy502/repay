package daoI;

import java.util.List;

import model.BeanItemBudget;

public interface IItemBudget {
	public void additembudget(BeanItemBudget itembudget);

	public BeanItemBudget Searchitembudget(int itembudgetId);

	public List<BeanItemBudget> loaditembudget();

	public List<BeanItemBudget> Searchitembudgetbybudgetid(int budgetId);

	public void modifryitembudget(BeanItemBudget itembudget);

	public void Delitembudget(BeanItemBudget itembudget);


}
