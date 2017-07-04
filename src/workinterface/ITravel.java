package workinterface;

public interface ITravel {
	public void addtravel(Beantravel travel);
	//添加交通地点表
	public Beantravel Searchtravel(int travelId);
	//搜索交通地点表
	public Beantravel loadtravel(int travelId);
	//搜索交通地点表
	public Beantravel loadAlltravel();
	//搜索交通地点表
	public void modifrytravel(Beantravel travel);
	//修改交通地点表
	public void Deltravel(Beantravel travel);
	//删除交通地点表
}
