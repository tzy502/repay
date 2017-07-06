package daoI;

import java.util.List;

import model.BeanItem;


public interface IItem {
	public void additem(BeanItem item);
	//添加预算
	public BeanItem Searchitem(int itemId);
	//搜索预算
	public List<BeanItem> loaditem(int itemId);
	//搜索预算
	public List<BeanItem> loadAllitem();
	//搜索预算
	public void modifryitem(BeanItem item);
	//修改预算
	public void Delitem(BeanItem item);
	//删除预算
}
