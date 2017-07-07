package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.BeanItem;
import serviceI.IItemService;
import util.BaseException;
@Service
public class ItemService implements IItemService {
	@Resource
	ItemDao id=new ItemDao();
	@Override
	public void addItem(String ItemName) throws BaseException {
		// TODO Auto-generated method stub
		BeanItem bi=new BeanItem();
		bi.setItemName(ItemName);
		id.additem(bi);
		
	}

	@Override
	public void updateItem(int itemId, String ItemName) throws BaseException {
		// TODO Auto-generated method stub
		BeanItem bi=new BeanItem();
		bi.setItemName(ItemName);
		bi.setItemId(itemId);
		id.modifryitem(bi);
		
	}

	@Override
	public BeanItem searchItem(int itemId) throws BaseException {
		// TODO Auto-generated method stub
		BeanItem bi=new BeanItem();
		bi=null;
		bi=id.Searchitem(itemId);
		if(bi==null){
			throw new BaseException("查无数据");
		}
		return bi;
	}

	@Override
	public List<BeanItem> loadAllItem() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanItem> result =new ArrayList<BeanItem>();
		result=id.loadAllitem();
				
		return null;
	}

	@Override
	public void DelItem(int itemId) throws BaseException {
		// TODO Auto-generated method stub
		id.Delitem(searchItem(itemId));
		
		
	}

}
