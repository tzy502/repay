package service;

import java.util.Date;
import java.util.List;

import dao.TravelDao;
import model.BeanTravel;
import serviceI.ITravelService;
import util.BaseException;

public class TravelService implements ITravelService {
	TravelDao td=new TravelDao();
	@Override
	public void addTravel(int repayId, String travelLocation, String travelProvince, Date startData, Date endData,
			int days, float plane, float train, float tasfficOther, float stayFees, float foodFees, float miFess,
			float other) throws BaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifryTravel(int travelId, int repayId, String travelLocation, String travelProvince, Date startData,
			Date endData, int days, float plane, float train, float tasfficOther, float stayFees, float foodFees,
			float miFess, float other) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delTravel(int travelId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanTravel searchTravel(int travelId) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanTravel> loadTravel() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
