package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.TravelUserDao;
import model.BeanTravelUser;
import serviceI.ITravelUserService;
import util.BaseException;
@Service
public class TravelUserService implements ITravelUserService {
	@Resource
	TravelUserDao tud=new TravelUserDao();
	@Override
	public void addTravelUser(int repayId, String userName, String userJob) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravelUser btu=new BeanTravelUser();
		btu.setRepayId(repayId);
		btu.setUserName(userName);
		btu.setUserJob(userJob);
		tud.addTravelUser(btu);
	}

	@Override
	public void modifryTravelUser(int travelUserId, int repayId, String userName, String userJob) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravelUser btu=new BeanTravelUser();
		btu.setRepayId(repayId);
		btu.setUserName(userName);
		btu.setUserJob(userJob);
		btu.setTravelUserId(travelUserId);
		tud.modifryTravelUser(btu);
	}

	@Override
	public void delTravelUser(int travelUserId) throws BaseException {
		// TODO Auto-generated method stub
		tud.delTravelUser(searchTravelUser(travelUserId));
	}

	@Override
	public BeanTravelUser searchTravelUser(int travelUserId) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravelUser btu=new BeanTravelUser(); 
		btu=null;
		btu=tud.SearchTravelUser(travelUserId);
		if(btu==null){		
			throw new BaseException("查无数据");
		}
		return btu;
	}

	@Override
	public List<BeanTravelUser> loadTravelUser() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTravelUser> result =new ArrayList<BeanTravelUser>();
		result =tud.loadAllTravelUser();
		return result;
	}

	@Override
	public List<BeanTravelUser> searchTravelUserbyrepayid(int repayid) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTravelUser> result =new ArrayList<BeanTravelUser>();
		result =tud.SearchTravelUserbyrepayid(repayid);
		return result;
	}

}
