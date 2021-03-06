package daoI;

import java.util.List;

import model.BeanProject;

public interface IProjectDao {
	public void addProject(BeanProject project);
	
	public void updateProject(BeanProject project);
	
	public void delProject(BeanProject project);
	
	public List<BeanProject> loadAllProject();
	
	public BeanProject searchProject(int projectId);
	
	public List<BeanProject> searchBudgetProject();
	
	public List<BeanProject> searchUserProject(String userId);
}
