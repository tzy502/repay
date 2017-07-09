package serviceI;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanProject;
import util.BaseException;
@Component
public interface IProjectService {
	public void addProject(BeanProject project)throws BaseException;
	
	public void modifryProject(BeanProject project)throws BaseException;
	
	public void delProject(int projectId)throws BaseException;
	
	public BeanProject SearchProject(int projectId)throws BaseException;
	
	public List<BeanProject> loadAllProject()throws BaseException;
	
	public List<BeanProject> searchBudgetProject()throws BaseException;
	
	public List<BeanProject> searchUserProject(String userId)throws BaseException;
}
