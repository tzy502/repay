package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSummary;
import util.BaseException;
@Component
public interface ISummaryService {
	public void addSummary(  int budgetId, String userId, String company, String projectId, int annex, 
			float sum, String manager,  String applicationId)throws BaseException; 
	public void modifrySummary(int summaryId, int budgetId, String userId, String company, String projectId, int annex, 
			float sum, String manager,  String applicationId)throws BaseException;
	public void delSummary(int summaryId)throws BaseException;
	public BeanSummary searchSummary(int summaryId) throws BaseException;
	public List<BeanSummary> loadSummary() throws BaseException;
}
