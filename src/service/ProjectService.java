package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ProjectDao;
import daoI.IProjectDao;
import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;
@Service
public class ProjectService implements IProjectService {
	@Resource
	private IProjectDao IProjectDao;
	@Override
	public void addProject(BeanProject project) throws BaseException {
		// TODO Auto-generated method stub
		IProjectDao.addProject(project);
	}

	@Override
	public void modifryProject(BeanProject project) throws BaseException {
		// TODO Auto-generated method stub
		BeanProject bp=IProjectDao.searchProject(project.getProjectId());
		if(bp.getIsBudget()==1){
			throw new BaseException("该项目已填写好预算，无法修改！");
		}
		bp.setProjectName(project.getProjectName());
		bp.setProjectType(project.getProjectType());
		bp.setProjectTypeId(project.getProjectTypeId());
		bp.setField(project.getField());
		bp.setFieldId(project.getFieldId());
		bp.setSource(project.getSource());
		bp.setSourceId(project.getSourceId());
		bp.setStartDate(project.getStartDate());
		bp.setEndDate(project.getEndDate());
		bp.setIsBudget(project.getIsBudget());
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

	@Override
	public List<BeanProject> searchUserProject(String userId) throws BaseException {
		// TODO 自动生成的方法存根
		List<BeanProject> result=new ArrayList<BeanProject>();
		 result=IProjectDao.searchUserProject(userId);
		 return result;
	}

	@Override
	public void updateProjectStatus(int projectId, int isBudget) throws BaseException {
		// TODO 自动生成的方法存根
		BeanProject bp=IProjectDao.searchProject(projectId);
		bp.setIsBudget(isBudget);
		IProjectDao.updateProject(bp);
	}

}
