package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanProject;
import util.BaseException;
@Component
public interface IProjectService {
	public void addProject()throws BaseException;
	public void modifryProject()throws BaseException;
	public void DelProject()throws BaseException;
	public BeanProject SearchProject()throws BaseException;
	public List<BeanProject> LoadProject()throws BaseException;
}
