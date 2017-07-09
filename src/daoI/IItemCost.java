package daoI;

import java.util.List;

import model.BeanItemCost;

public interface IItemCost {
	public void additemcost(BeanItemCost itemcost);

	public BeanItemCost Searchitemcost(int itemcostId);

	public List<BeanItemCost> loaditemcost(int itemcostId);

	public List<BeanItemCost> loadAllitemcost();

	public void modifryitemcost(BeanItemCost itemcost);

	public void Delitemcost(BeanItemCost itemcost);
	
	public List<BeanItemCost> loadItemcostBySId(int summaryId);

}
