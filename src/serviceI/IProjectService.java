package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanProject;
import util.BaseException;
@Component
public interface IProjectService {
	public void addProject( String projectName, String projectType, String projectTypeId, String field, String fieldId, String source,
			String sourceId, Date prostartDate, Date proendDate	)throws BaseException;
	public void modifryProject(int projectId,String projectName, String projectType, String projectTypeId, String field, 
			String fieldId, String source,String sourceId, Date prostartDate, Date proendDate)throws BaseException;
	public void delProject(int projectId)throws BaseException;
	public BeanProject SearchProject(int projectId)throws BaseException;
	public List<BeanProject> loadAllProject()throws BaseException;
}
