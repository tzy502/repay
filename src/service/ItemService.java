package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import daoI.IItemDao;
import model.BeanItem;
import serviceI.IItemService;
import util.BaseException;

@Service
public class ItemService implements IItemService{
	@Resource
	private IItemDao ItemDao;
	public ItemService(){
	      System.out.println("ItemService Constructor...\n\n\n\n\n\n");
	}
	
	@Override
	public void addItem(String ItemName) throws BaseException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void updateItem(String itemId, String ItemName) throws BaseException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public BeanItem searchItem(String itemId) throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<BeanItem> loadAllItem() throws BaseException {
		// TODO 自动生成的方法存根
		return null;
	}

}
