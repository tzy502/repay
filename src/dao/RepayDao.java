package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import daoI.IRepay;
import model.BeanBudget;
import model.BeanRepay;
@Repository
public class RepayDao implements IRepay {

	@Override
	public void addRepay(BeanRepay Repay) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Repay);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanRepay SearchRepay(int RepayId) {
		// TODO Auto-generated method stub
		BeanRepay result =new BeanRepay();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanRepay where userid=?");
		qry.setParameter(0, RepayId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanRepay)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanRepay> loadRepay(int RepayId) {
		// TODO Auto-generated method stub
		List<BeanRepay> result =new ArrayList<BeanRepay>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanRepay");
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
	public List<BeanRepay> loadAllRepay() {
		// TODO Auto-generated method stub
		List<BeanRepay> result =new ArrayList<BeanRepay>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanRepay");
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
	public void modifryRepay(BeanRepay Repay) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Repay);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelRepay(BeanRepay Repay) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(Repay);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	public int repaymaxId() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "select max(repayId) from BeanRepay";
		Query qry = s.createQuery(hql);
		java.util.List<Integer> list=qry.list(); 
		int maxid=list.get(0);
		tx.commit();
		return maxid;
	}
}
