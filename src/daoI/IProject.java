package daoI;

import java.util.List;

import model.BeanProject;

public interface IProject {
	public void addProject(BeanProject project);
	
	public void updateProject(BeanProject project);
	
	public void delProject(BeanProject project);
	
	public List<BeanProject> loadAllProject();
	
	public BeanProject searchProject(String projectId);
}
