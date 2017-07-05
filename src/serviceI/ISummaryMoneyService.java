package serviceI;

import java.util.List;

import model.BeanSummaryMoney;
import util.BaseException;

public interface ISummaryMoneyService {
	public void addSummaryMoney( int summaryprojectid, int summaryid, float cost)throws BaseException;
	public void modrifySummaryMoney( int keyword, int summaryprojectid, int summaryid, float cost)throws BaseException;
	public void delSummaryMoney(int key)throws BaseException;
	public BeanSummaryMoney searcjSummaryMoney(int key)throws BaseException;
	public List<BeanSummaryMoney> loadSummaryMoney()throws BaseException;
}
