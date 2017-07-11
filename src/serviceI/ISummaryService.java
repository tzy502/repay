package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSummary;
import util.BaseException;
@Component
public interface ISummaryService {
	public void addSummary(String userId, String company, String projectId, int billCount, float sum, String workerId,
			String userName, float money, String cardNumber, String manager, String applicationId)throws BaseException; 
	public void modifrySummary(int summaryId,String userId, String company, String projectId, int billCount, float sum, String workerId,
			String userName, float money, String cardNumber, String manager, String applicationId)throws BaseException;
	public void delSummary(int summaryId)throws BaseException;
	public BeanSummary searchSummary(int summaryId) throws BaseException;
	public List<BeanSummary> loadSummary() throws BaseException;
	public int Searchmaxnuk(String userId ,String projectId)throws BaseException;
	
	public List<BeanSummary> loadASummary() throws BaseException;
	
	public List<BeanSummary> loadAllSummaryByUId(String userId) throws BaseException;
}
