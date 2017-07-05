package daoI;

import java.util.List;

import model.BeanSummaryMoney;



public interface ISummaryMoney {
	public void addsummarymoney(BeanSummaryMoney summarymoney);

	public BeanSummaryMoney Searchsummarymoney(int summarymoneyId);

	public List<BeanSummaryMoney> loadsummarymoney(int summarymoneyId);

	public List<BeanSummaryMoney> loadAllsummarymoney();

	public void modifrysummarymoney(BeanSummaryMoney summarymoney);

	public void Delsummarymoney(BeanSummaryMoney summarymoney);

}
