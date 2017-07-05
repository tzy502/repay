package service;

import java.util.List;

import model.BeanTravelUser;
import serviceI.ITravelUserService;
import util.BaseException;

public class TravelUserService implements ITravelUserService {

	@Override
	public void addTravelUser(String travelId, String userId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifryTravelUser(int travelUserId, String travelId, String userId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delTravelUser(int travelUserId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanTravelUser searchTravelUser(int travelUserId) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanTravelUser> loadTravelUser() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
