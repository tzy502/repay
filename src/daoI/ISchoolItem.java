package daoI;

import java.util.List;

import model.BeanSchoolItem;

public interface ISchoolItem {
	public void addschoolitem(BeanSchoolItem schoolitem);

	public BeanSchoolItem Searchschoolitem(int schoolitemId);

	public List<BeanSchoolItem> loadschoolitem(int schoolitemId);

	public List<BeanSchoolItem> loadAllschoolitem();

	public void modifryschoolitem(BeanSchoolItem schoolitem);

	public void Delschoolitem(BeanSchoolItem schoolitem);
}
