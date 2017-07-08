package dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import daoI.IBudget;
import model.BeanBudget;
import model.BeanUser;
@Repository
public class BudgetDao implements IBudget {

	@Override
	public void addbudget(BeanBudget budget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(budget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanBudget Searchbudget(int budgetId) {
		// TODO Auto-generated method stub
		BeanBudget result =new BeanBudget();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanBudget where budgetId=?");
		qry.setParameter(0, budgetId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanBudget)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;

	}

	@Override
	public  List<BeanBudget> loadbudget(int budgetId) {
		// TODO Auto-generated method stub
		List<BeanBudget> result =new ArrayList<BeanBudget>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanBudget");
			qry.setParameter(0, budgetId);
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
	public List<BeanBudget> loadAllbudget() {
		// TODO Auto-generated method stub
		List<BeanBudget> result =new ArrayList<BeanBudget>();
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
	public void modifrybudget(BeanBudget budget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(budget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void Delbudget(BeanBudget budget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(budget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public int SearchmaxId(int projectId, float budgetSum, float independentFees, float applyFees) {
		// TODO Auto-generated method stub
		int result ;
		result=-1;
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("select max(budgetId) from BeanBudget"
				+ "		 where projectId=?");
		qry.setParameter(0, projectId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(int)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println(result);
		return result;
	}

}
