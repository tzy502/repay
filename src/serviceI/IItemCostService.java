package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanItemCost;
import util.BaseException;
@Component
public interface IItemCostService {
	public void addItemCost( int summary, int schoolItemId, String itemCostName, float itemCost	)throws BaseException;
	public void modifryItemCost(int itemCostId,int summary, int schoolItemId, String itemCostName, float itemCost)throws BaseException;
	public void DelItemCost(int itemCostId)throws BaseException;
	public BeanItemCost SearchItemCost(int itemCostId)throws BaseException;
	public List<BeanItemCost> LoadItemCost()throws BaseException;
}
