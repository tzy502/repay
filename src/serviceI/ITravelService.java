package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTravel;
import util.BaseException;
@Component
public interface ITravelService {
	public void addTravel(  int repayId, String travelLocation, String travelProvince, Date  startData, Date endData, 
			int days, float plane, float train, float tasfficOther, float stayFees, float foodFees,
			float miFess, float other)throws BaseException; 
	public void modifryTravel( int travelId, int repayId, String travelLocation, String travelProvince, Date  startData, Date endData, 
			int days, float plane, float train, float tasfficOther, float stayFees, float foodFees,
			float miFess, float other)throws BaseException;
	public void delTravel(int travelId)throws BaseException;
	public BeanTravel searchTravel(int travelId) throws BaseException;
	public List<BeanTravel> loadTravel() throws BaseException;
}
