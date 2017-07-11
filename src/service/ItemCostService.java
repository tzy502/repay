package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ItemCostDao;
import model.BeanItemCost;
import serviceI.IItemCostService;
import util.BaseException;
@Service
public class ItemCostService implements IItemCostService {
	@Resource
	private ItemCostDao icd;
	@Override
	public void addItemCost(int summary, int schoolItemId, String itemCostName, float itemCost) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemCost bic=new BeanItemCost();
		bic.setSummaryId(summary);
		bic.setoItemId(schoolItemId);
		bic.setItemCostName(itemCostName);
		bic.setItemCost(itemCost);
		icd.additemcost(bic);
	}

	@Override
	public void modifryItemCost(int itemCostId, int summary, int schoolItemId, String itemCostName, float itemCost)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanItemCost bic=new BeanItemCost();
		bic.setSummaryId(summary);
		bic.setoItemId(schoolItemId);
		bic.setItemCostName(itemCostName);
		bic.setItemCost(itemCost);
		bic.setItemCostId(itemCostId);
		icd.modifryitemcost(bic);
	}

	@Override
	public void DelItemCost(int itemCostId) throws BaseException {
		// TODO Auto-generated method stub
		icd.Delitemcost(SearchItemCost(itemCostId));
	}

	@Override
	public BeanItemCost SearchItemCost(int itemCostId) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemCost bic=new BeanItemCost();
		bic=null;
		bic=icd.Searchitemcost(itemCostId);
				
		if (bic==null){
			throw new BaseException("查无数据");
		}
		return bic;
	}

	@Override
	public List<BeanItemCost> LoadItemCost() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanItemCost> result=new ArrayList<BeanItemCost>();
		result=icd.loadAllitemcost();
				
		return result;
		
	}

	@Override
	public List<BeanItemCost> searchItemCostBySId(int summaryId) throws BaseException {
		// TODO 自动生成的方法存根
		List<BeanItemCost> result=new ArrayList<BeanItemCost>();
		result=icd.loadItemcostBySId(summaryId);
				
		return result;
	}

	@Override
	public float searchSumGB(int summaryId, int oItemId) throws BaseException {
		// TODO 自动生成的方法存根
		return (float)icd.searchSumGB(summaryId, oItemId);
	}

}
