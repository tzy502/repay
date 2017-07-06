package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daoI.ISchoolItem;
import model.BeanBudget;
import model.BeanSchoolItem;
import util.HibernateUtil;

public class SchoolItem implements ISchoolItem {

	@Override
	public void addschoolitem(BeanSchoolItem schoolitem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(schoolitem);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSchoolItem Searchschoolitem(int schoolitemId) {
		// TODO Auto-generated method stub
		BeanSchoolItem result =new BeanSchoolItem();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanSchoolItem where userid=?");
		qry.setParameter(0, schoolitemId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanSchoolItem)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanSchoolItem> loadschoolitem(int schoolitemId) {
		// TODO Auto-generated method stub
		List<BeanSchoolItem> result =new ArrayList<BeanSchoolItem>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanBudget");

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
	public List<BeanSchoolItem> loadAllschoolitem() {
		// TODO Auto-generated method stub
		List<BeanSchoolItem> result =new ArrayList<BeanSchoolItem>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanBudget");
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
	public void modifryschoolitem(BeanSchoolItem schoolitem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(schoolitem);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void Delschoolitem(BeanSchoolItem schoolitem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(schoolitem);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
