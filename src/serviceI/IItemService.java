package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanItem;
import util.BaseException;

@Component
public interface IItemService {
	//添加
	public void addItem(String ItemName)throws BaseException;
	
	//修改
	public void updateItem(int itemId, String ItemName)throws BaseException;
	
	public void DelItem(int itemId)throws BaseException;
	//查询
	public BeanItem searchItem(int itemId)throws BaseException;
	
	//导出所有
	public List<BeanItem> loadAllItem()throws BaseException;
	
}
