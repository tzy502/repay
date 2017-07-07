package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.BeanItem;
import model.BeanRole;
import serviceI.IItemService;
import daoI.IItemDao;
import util.BaseException;
@Service
public class ItemService implements IItemService{
	@Resource
	private IItemDao IItemDao;
	
	@Override
	public void addItem(String ItemName) throws BaseException {
		 
		
	}

	@Override
	public void updateItem(int itemId, String ItemName) throws BaseException {
		 
		
	}

	@Override
	public void DelItem(int itemId) throws BaseException {
		 
		
	}

	@Override
	public BeanItem searchItem(int itemId) throws BaseException {
		 
		return null;
	}

	@Override
	public List<BeanItem> loadAllItem() throws BaseException { 
		List<BeanItem> result =new ArrayList<BeanItem>();
		result=IItemDao.loadAllItem();
		return result;
	}

}
