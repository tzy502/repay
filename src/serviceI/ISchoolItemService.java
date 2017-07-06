package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSchoolItem;
import util.BaseException;
@Component
public interface ISchoolItemService {
	public void addSchoolItem()throws BaseException;
	public void modifrySchoolItem()throws BaseException;
	public void DelSchoolItem()throws BaseException;
	public BeanSchoolItem SearchSchoolItem()throws BaseException;
	public List<BeanSchoolItem> LoadSchoolItem()throws BaseException;
}
