package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanItemCost;
import util.BaseException;
@Component
public interface IItemCostService {
	public void addItemCost()throws BaseException;
	public void modifryItemCost()throws BaseException;
	public void DelItemCost()throws BaseException;
	public BeanItemCost SearchItemCost()throws BaseException;
	public List<BeanItemCost> LoadItemCost()throws BaseException;
}
