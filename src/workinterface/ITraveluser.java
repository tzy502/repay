package workinterface;

import model.BeanTravelUser;

public interface ITraveluser {
	public void addTraveluser(BeanTravelUser Traveluser);
	//添加报销单
	public BeanTravelUser SearchTraveluser(int TraveluserId);
	//搜索报销单
	public BeanTravelUser loadTraveluser(int TraveluserId);
	//搜索报销单
	public BeanTravelUser loadAllTraveluser();
	//搜索报销单
	public void modifryTraveluser(BeanTravelUser Traveluser);
	//修改报销单
	public void DelTraveluser(BeanTravelUser Traveluser);
	//删除报销单
}
