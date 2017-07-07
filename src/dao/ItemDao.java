package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IItemDao;
import model.BeanBudget;
import model.BeanItem;
import model.BeanUser;
import util.HibernateUtil;

@Repository
public class ItemDao implements IItemDao {
	public ItemDao(){
	      System.out.println("ItemDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addItem(BeanItem item) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(item);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanItem SearchItem(int itemId) {
		// TODO Auto-generated method stub
		BeanItem result =new BeanItem();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanItem where userid=?");
		qry.setParameter(0, itemId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanItem)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanItem> loadItem(int itemId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<BeanItem> result =new ArrayList<BeanItem>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItem");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanItem> loadAllItem() {
		// TODO Auto-generated method stub
		List<BeanItem> result =new ArrayList<BeanItem>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItem");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public void modifryItem(BeanItem item) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(item);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delItem(BeanItem item) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(item);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public static void main(String arg[]){
		List<BeanItem> item = new ItemDao().loadAllItem();
		System.out.println(item.get(0).getItemName());
	}
}
