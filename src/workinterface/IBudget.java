package workinterface;

public interface IBudget {
	//预算表
	public void addbudget(Beanbudget budget);
	//添加预算
	public Beanbudget Searchbudget(int budgetId);
	//搜索预算
	public Beanbudget loadbudget(int budgetId);
	//搜索预算
	public Beanbudget loadAllbudget();
	//搜索预算
	public void modifrybudget(Beanbudget budget);
	//修改预算
	public void Delbudget(Beanbudget budget);
	//删除预算
}
