package workinterface;

import model.BeanSummary;

public interface ISummary {
	public void addSummary(BeanSummary Summary);
	//添加汇总单
	public BeanSummary SearchSummary(int SummaryId);
	//搜索汇总单
	public BeanSummary loadSummary(int SummaryId);
	//搜索汇总单
	public BeanSummary loadAllSummary();
	//搜索汇总单
	public void modifrySummary(BeanSummary Summary);
	//修改汇总单
	public void DelSummary(BeanSummary Summary);
	//删除汇总单
}
