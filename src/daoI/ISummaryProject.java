package daoI;

import java.util.List;

import model.BeanSummaryProject;

public interface ISummaryProject {
	public void addSummaryProject(BeanSummaryProject SummaryProject);

	public BeanSummaryProject SearchSummaryProject(int SummaryProjectId);

	public List<BeanSummaryProject> loadSummaryProject(int SummaryProjectId);

	public List<BeanSummaryProject> loadAllSummaryProject();

	public void modifrySummaryProject(BeanSummaryProject SummaryProject);

	public void DelSummaryProject(BeanSummaryProject SummaryProject);
}
