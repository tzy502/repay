package serviceI;

import java.util.List;

import model.BeanTravelUser;
import util.BaseException;

public interface ITravelUserService {
	public void addTravelUser(String travelId,String userId)throws BaseException; 
	public void modifryTravelUser(int travelUserId,String travelId,String userId)throws BaseException;
	public void delTravelUser(int travelUserId)throws BaseException;
	public BeanTravelUser searchTravelUser(int travelUserId) throws BaseException;
	public List<BeanTravelUser> loadTravelUser() throws BaseException;
}
