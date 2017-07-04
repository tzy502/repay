package daoI;

import model.BeanTravel;

public interface ITravel {
	public void addtravel(BeanTravel travel);
	//添加交�?�地点表
	public BeanTravel Searchtravel(int travelId);
	//搜索交�?�地点表
	public BeanTravel loadtravel(int travelId);
	//搜索交�?�地点表
	public BeanTravel loadAlltravel();
	//搜索交�?�地点表
	public void modifrytravel(BeanTravel travel);
	//修改交�?�地点表
	public void Deltravel(BeanTravel travel);
	//删除交�?�地点表
}
