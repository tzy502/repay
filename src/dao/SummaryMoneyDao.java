package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daoI.ISummaryMoney;
import model.BeanBudget;
import model.BeanSummaryMoney;
import util.HibernateUtil;

public class SummaryMoneyDao implements ISummaryMoney {

	@Override
	public void addsummarymoney(BeanSummaryMoney summarymoney) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(summarymoney);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSummaryMoney Searchsummarymoney(int summarymoneyId) {
		BeanSummaryMoney result =new BeanSummaryMoney();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanSummaryMoney where userid=?");
		qry.setParameter(0, summarymoneyId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanSummaryMoney)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;

	}

	@Override
	public List<BeanSummaryMoney> loadsummarymoney(int summarymoneyId) {
		List<BeanSummaryMoney> result =new ArrayList<BeanSummaryMoney>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummaryMoney");
			qry.setParameter(0, summarymoneyId);
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
	public List<BeanSummaryMoney> loadAllsummarymoney() {
		List<BeanSummaryMoney> result =new ArrayList<BeanSummaryMoney>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummaryMoney");
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
	public void modifrysummarymoney(BeanSummaryMoney summarymoney) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(summarymoney);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void Delsummarymoney(BeanSummaryMoney summarymoney) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(summarymoney);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
