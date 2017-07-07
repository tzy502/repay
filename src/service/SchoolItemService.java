package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.SchoolItemDao;
import model.BeanSchoolItem;
import serviceI.ISchoolItemService;
import util.BaseException;
@Service
public class SchoolItemService implements ISchoolItemService {
	@Resource
	SchoolItemDao sid=new SchoolItemDao(); 
	@Override
	public void addSchoolItem(int itemId, String schoolItemName) throws BaseException {
		// TODO Auto-generated method stub
		BeanSchoolItem bci=new BeanSchoolItem();
		bci.setItemId(itemId);
		bci.setSchoolItemName(schoolItemName);
		sid.addschoolitem(bci);
	}

	@Override
	public void modifrySchoolItem(int schoolItemId, int itemId, String schoolItemName) throws BaseException {
		// TODO Auto-generated method stub
		BeanSchoolItem bci=new BeanSchoolItem();
		bci.setItemId(itemId);
		bci.setSchoolItemName(schoolItemName);
		bci.setSchoolItemId(schoolItemId);
		sid.modifryschoolitem(bci);
	}

	@Override
	public void DelSchoolItem(int schoolItemId) throws BaseException {
		// TODO Auto-generated method stub
		sid.Delschoolitem(SearchSchoolItem(schoolItemId));
	}

	@Override
	public BeanSchoolItem SearchSchoolItem(int schoolItemId) throws BaseException {
		// TODO Auto-generated method stub
		BeanSchoolItem bci=new BeanSchoolItem();
		bci=null;
		bci=sid.Searchschoolitem(schoolItemId);
		if(bci==null){
			throw new BaseException("查无数据");
		}
		return bci;
	}

	@Override
	public List<BeanSchoolItem> LoadSchoolItem() throws BaseException {
		// TODO Auto-generated method stub
		System.out.println("service");
		List<BeanSchoolItem> result =new ArrayList<BeanSchoolItem>();
		result=sid.loadAllschoolitem();
		return result;
	}

}
