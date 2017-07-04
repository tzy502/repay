package workinterface;

import model.BeanTravel;

public interface ITravel {
	public void addtravel(BeanTravel travel);
	//添加交通地点表
	public BeanTravel Searchtravel(int travelId);
	//搜索交通地点表
	public BeanTravel loadtravel(int travelId);
	//搜索交通地点表
	public BeanTravel loadAlltravel();
	//搜索交通地点表
	public void modifrytravel(BeanTravel travel);
	//修改交通地点表
	public void Deltravel(BeanTravel travel);
	//删除交通地点表
}
