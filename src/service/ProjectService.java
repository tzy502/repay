package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ProjectDao;
import daoI.IProject;
import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;
@Service
public class ProjectService implements IProjectService {
	@Resource
	private IProject IProjectDao;
	@Override
	public void addProject(BeanProject project) throws BaseException {
		// TODO Auto-generated method stub
		IProjectDao.addProject(project);
	}

	@Override
	public void modifryProject(int projectId, String projectName, String projectType, String projectTypeId,
			String field, String fieldId, String source, String sourceId, Date prostartDate, Date proendDate)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanProject bp=new BeanProject();
		bp.setProjectName(projectName);
		bp.setProjectType(projectType);
		bp.setProjectTypeId(projectTypeId);
		bp.setField(field);
		bp.setFieldId(fieldId);
		bp.setSource(source);
		bp.setSourceId(sourceId);
		bp.setStartDate(prostartDate);
		bp.setEndDate(proendDate);
		bp.setProjectId(projectId);
		bp.setIsBudget(0);
		IProjectDao.updateProject(bp);
		
	}

	@Override
	public void delProject(int projectId) throws BaseException {
		// TODO Auto-generated method stub
		IProjectDao.delProject(SearchProject(projectId));
	}

	@Override
	public BeanProject SearchProject(int projectId) throws BaseException {
		// TODO Auto-generated method stub
		BeanProject bp=new BeanProject();
		bp=null;
		bp=IProjectDao.searchProject(projectId);
		if(bp==null){
			throw new BaseException("查无数据");
		}
		return bp;
	}

	@Override
	public List<BeanProject> loadAllProject() throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanProject> result=new ArrayList<BeanProject>();
		 result=IProjectDao.loadAllProject();
				 
		return result;
	}

	@Override
	public List<BeanProject> searchBudgetProject() throws BaseException {
		// TODO 自动生成的方法存根
		List<BeanProject> result=new ArrayList<BeanProject>();
		 result=IProjectDao.searchBudgetProject();
		 return result;
	}

}
