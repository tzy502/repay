package workinterface;

public interface IRepay {
	public void addRepay(BeanRepay Repay);
	//添加报销单
	public BeanRepay SearchRepay(int RepayId);
	//搜索报销单
	public BeanRepay loadRepay(int RepayId);
	//搜索报销单
	public BeanRepay loadAllRepay();
	//搜索报销单
	public void modifryRepay(BeanRepay Repay);
	//修改报销单
	public void DelRepay(BeanRepay Repay);
	//删除报销单
}
