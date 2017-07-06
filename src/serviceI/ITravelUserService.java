package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanTravelUser;
import util.BaseException;
@Component
public interface ITravelUserService {
	public void addTravelUser( int repayId, String userName, String userJob)throws BaseException; 
	public void modifryTravelUser(int travelUserId,int repayId, String userName, String userJob)throws BaseException;
	public void delTravelUser(int travelUserId)throws BaseException;
	public BeanTravelUser searchTravelUser(int travelUserId) throws BaseException;
	public List<BeanTravelUser> loadTravelUser() throws BaseException;
}
