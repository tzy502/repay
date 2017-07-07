package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ProjectDao;
import model.BeanProject;
import serviceI.IProjectService;
import util.BaseException;
@Service
public class ProjectService implements IProjectService {
	@Resource
	ProjectDao pd=new ProjectDao();
	@Override
	public void addProject(String projectName, String projectType, String projectTypeId, String field, String fieldId,
			String source, String sourceId, Date prostartDate, Date proendDate) throws BaseException {
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
		pd.addProject(bp);
		
		
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
		pd.updateProject(bp);
		
	}

	@Override
	public void DelProject(int projectId) throws BaseException {
		// TODO Auto-generated method stub
		pd.delProject(SearchProject(projectId));
	}

	@Override
	public BeanProject SearchProject(int projectId) throws BaseException {
		// TODO Auto-generated method stub
		BeanProject bp=new BeanProject();
		bp=null;
		bp=pd.searchProject(projectId);
		if(bp==null){
			throw new BaseException("查无数据");
		}
		return bp;
	}

	@Override
	public List<BeanProject> loadAllProject() throws BaseException {
		// TODO Auto-generated method stub
		 List<BeanProject> result=new ArrayList<BeanProject>();
		 result=pd.loadAllProject();
				 
		return result;
	}

}
