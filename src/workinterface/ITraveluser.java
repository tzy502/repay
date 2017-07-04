package workinterface;

public interface ITraveluser {
	public void addTraveluser(BeanTraveluser Traveluser);
	//添加报销单
	public BeanTraveluser SearchTraveluser(int TraveluserId);
	//搜索报销单
	public BeanTraveluser loadTraveluser(int TraveluserId);
	//搜索报销单
	public BeanTraveluser loadAllTraveluser();
	//搜索报销单
	public void modifryTraveluser(BeanTraveluser Traveluser);
	//修改报销单
	public void DelTraveluser(BeanTraveluser Traveluser);
	//删除报销单
}
