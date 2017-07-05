package daoI;

import java.util.List;

import model.BeanTravelUser;

public interface ITravelUserDao {
	public void addTravelUser(BeanTravelUser TravelUser);
	//添加
	
	public BeanTravelUser SearchTravelUser(int TravelUserId);
	//搜索

	public List<BeanTravelUser> loadAllTravelUser();
	//搜索
	
	public void modifryTravelUser(BeanTravelUser TravelUser);
	//修改

	public void delTravelUser(BeanTravelUser TravelUser);
	//删除
}
