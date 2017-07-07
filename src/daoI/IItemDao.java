package daoI;

import java.util.List;

import model.BeanItem;


public interface IItemDao {
	public void addItem(BeanItem item);
	//添加预算
	public BeanItem SearchItem(int itemId);
	//搜索预算
	public List<BeanItem> loadItem(int itemId);
	//搜索预算
	public List<BeanItem> loadAllItem();
	//搜索预算
	public void modifryItem(BeanItem item);
	//修改预算
	public void delItem(BeanItem item);
	//删除预算
}
