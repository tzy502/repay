package daoI;

import java.util.List;

import model.BeanTravel;

public interface ITravelDao {
	public void addTravel(BeanTravel travel);
	//添加交�?�地点表
	
	public BeanTravel SearchTravel(int travelId);
	//搜索交�?�地点表
	
	public List<BeanTravel> loadAllTravel();
	//搜索交�?�地点表
	public int TravelmaxId();
	public void modifryTravel(BeanTravel travel);
	//修改交�?�地点表
	
	public void delTravel(BeanTravel travel);
	//删除交�?�地点表
}
