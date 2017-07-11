package daoI;

import java.util.List;

import model.BeanSummary;

public interface ISummary {
	public void addSummary(BeanSummary Summary);
	//添加汇�?�单
	public BeanSummary SearchSummary(int SummaryId);
	//搜索汇�?�单
	public List<BeanSummary> loadSummary(int SummaryId);
	//搜索汇�?�单
	public List<BeanSummary> loadAllSummary();
	//搜索汇�?�单
	public void modifrySummary(BeanSummary Summary);
	//修改汇�?�单
	public void DelSummary(BeanSummary Summary);
	//删除汇�?�单
	public int  SearchSummaryid(String userId ,String projectId);
	
	public List<BeanSummary> loadASummary();
}
