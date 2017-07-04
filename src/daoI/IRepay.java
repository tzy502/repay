package daoI;

import model.BeanRepay;

public interface IRepay {
	public void addRepay(BeanRepay Repay);
	//添加报销�?
	public BeanRepay SearchRepay(int RepayId);
	//搜索报销�?
	public BeanRepay loadRepay(int RepayId);
	//搜索报销�?
	public BeanRepay loadAllRepay();
	//搜索报销�?
	public void modifryRepay(BeanRepay Repay);
	//修改报销�?
	public void DelRepay(BeanRepay Repay);
	//删除报销�?
}
