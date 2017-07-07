package service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.BeanItem;
import serviceI.IItemService;
import daoI.IItemDao;
import util.BaseException;
@Service
public class ItemService implements IItemService{
	@Resource
	private IItemDao IItemDao;
	
	@Override
	public void addItem(String itemName) throws BaseException {
		 BeanItem item  = new BeanItem();
		 item.setItemName(itemName);
		 IItemDao.addItem(item);
	}

	@Override
	public void updateItem(int itemId, String itemName) throws BaseException {
		 BeanItem item = IItemDao.SearchItem(itemId);
		 item.setItemName(itemName);
		 IItemDao.modifryItem(item);
		
	}

	@Override
	public void delItem(int itemId) throws BaseException {
		BeanItem item = IItemDao.SearchItem(itemId);
		IItemDao.delItem(item);
	}

	@Override
	public BeanItem searchItem(int itemId) throws BaseException { 
		return IItemDao.SearchItem(itemId);
	}

	@Override
	public List<BeanItem> loadAllItem() throws BaseException { 
		List<BeanItem> result =new ArrayList<BeanItem>();
		result=IItemDao.loadAllItem();
		return result;
	}

}
