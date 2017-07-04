package workinterface;

import model.BeanBudget;

public interface IBudget {
	//预算表
	public void addbudget(BeanBudget budget);
	//添加预算
	public BeanBudget Searchbudget(int budgetId);
	//搜索预算
	public BeanBudget loadbudget(int budgetId);
	//搜索预算
	public BeanBudget loadAllbudget();
	//搜索预算
	public void modifrybudget(BeanBudget budget);
	//修改预算
	public void Delbudget(BeanBudget budget);
	//删除预算
}
