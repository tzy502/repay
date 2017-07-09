package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.TravelDao;
import model.BeanTravel;
import serviceI.ITravelService;
import util.BaseException;
@Service
public class TravelService implements ITravelService {
	@Resource
	TravelDao td=new TravelDao();
	@Override
	public void addTravel(int repayId, String travelLocation, String travelProvince, Date startData, Date endData,
			int days, float plane, float train, float tasfficOther, float stayFees, float foodFees, float miFess,
			float other) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravel bt=new BeanTravel();
		bt.setRepayId(repayId);
		bt.setTravelLocation(travelLocation);
		bt.setTravelProvince(travelProvince);
		bt.setStartData(startData);
		bt.setEndData(endData);
		bt.setDays(days);
		bt.setPlane(plane);
		bt.setTrain(train);
		bt.setTasfficOther(tasfficOther);
		bt.setStayFees(stayFees);
		bt.setFoodFees(foodFees);
		bt.setMiFess(miFess);
		bt.setOther(other);
		td.addTravel(bt);
		
	}

	@Override
	public void modifryTravel(int travelId, int repayId, String travelLocation, String travelProvince, Date startData,
			Date endData, int days, float plane, float train, float tasfficOther, float stayFees, float foodFees,
			float miFess, float other) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravel bt=new BeanTravel();
		bt.setTravelId(travelId);
		bt.setRepayId(repayId);
		bt.setTravelLocation(travelLocation);
		bt.setTravelProvince(travelProvince);
		bt.setStartData(startData);
		bt.setEndData(endData);
		bt.setDays(days);
		bt.setPlane(plane);
		bt.setTrain(train);
		bt.setTasfficOther(tasfficOther);
		bt.setStayFees(stayFees);
		bt.setFoodFees(foodFees);
		bt.setMiFess(miFess);
		bt.setOther(other);
		td.modifryTravel(bt);
		
	}

	@Override
	public void delTravel(int travelId) throws BaseException {
		// TODO Auto-generated method stub
		td.delTravel(searchTravel(travelId));
	}

	@Override
	public BeanTravel searchTravel(int travelId) throws BaseException {
		// TODO Auto-generated method stub
		BeanTravel bt=new BeanTravel();
		bt=null;
		bt=td.SearchTravel(travelId);
		if(bt==null){		
			throw new BaseException("查无数据");
		}
		return bt;
	}

	@Override
	public List<BeanTravel> loadTravel() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTravel> result =new ArrayList<BeanTravel>();
		result =td.loadAllTravel();
				
		return result;
	}

	@Override
	public List<BeanTravel> searchTravelbyrepayid(int repayid) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanTravel> result =new ArrayList<BeanTravel>();
		result =td.SearchTravelbyrepayid(repayid);
		return result;
	}

}
