package serviceI;

import java.util.List;

import model.BeanSummaryProject;
import util.BaseException;

public interface ISummaryProjectService {
	public void addSummaryProject(String summaryprjectname)throws BaseException;
	public void modrifySummaryProject(String summaryprjectname)throws BaseException;
	public void delSummaryProject(int summaryprjectid)throws BaseException;
	public BeanSummaryProject searcjSummaryProject(int summaryprjectid)throws BaseException;
	public List<BeanSummaryProject> loadSummaryProject()throws BaseException;
}
