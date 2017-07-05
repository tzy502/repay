package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import daoI.ISummaryProject;
import model.BeanSummaryMoney;
import model.BeanSummaryProject;
import util.HibernateUtil;

public class SummaryProjectDao implements ISummaryProject {

	@Override
	public void addSummaryProject(BeanSummaryProject SummaryProject) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(SummaryProject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSummaryProject SearchSummaryProject(int SummaryProjectId) {
		BeanSummaryProject result =new BeanSummaryProject();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanSummaryProject where userid=?");
		qry.setParameter(0, SummaryProjectId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanSummaryProject)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanSummaryProject> loadSummaryProject(int SummaryProjectId) {
		List<BeanSummaryProject> result =new ArrayList<BeanSummaryProject>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummaryProject");
			qry.setParameter(0, SummaryProjectId);
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
	public List<BeanSummaryProject> loadAllSummaryProject() {
		List<BeanSummaryProject> result =new ArrayList<BeanSummaryProject>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummaryProject");
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
	public void modifrySummaryProject(BeanSummaryProject SummaryProject) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(SummaryProject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void DelSummaryProject(BeanSummaryProject SummaryProject) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(SummaryProject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
