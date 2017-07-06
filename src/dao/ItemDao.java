package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daoI.IItem;
import model.BeanBudget;
import model.BeanItem;
import util.HibernateUtil;

public class ItemDao implements IItem {

	@Override
	public void additem(BeanItem item) {
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
	public BeanItem Searchitem(int itemId) {
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
	public List<BeanItem> loaditem(int itemId) {
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
	public List<BeanItem> loadAllitem() {
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
	public void modifryitem(BeanItem item) {
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
	public void Delitem(BeanItem item) {
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

}
