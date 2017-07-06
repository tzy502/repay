package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanSchoolItem;
import util.BaseException;
@Component
public interface ISchoolItemService {
	public void addSchoolItem( int itemId, String schoolItemName)throws BaseException;
	public void modifrySchoolItem(int schoolItemId,int itemId, String schoolItemName)throws BaseException;
	public void DelSchoolItem(int schoolItemId)throws BaseException;
	public BeanSchoolItem SearchSchoolItem(int schoolItemId)throws BaseException;
	public List<BeanSchoolItem> LoadSchoolItem()throws BaseException;
}
