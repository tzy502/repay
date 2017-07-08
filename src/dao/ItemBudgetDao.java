package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IItemBudget;
import model.BeanBudget;
import model.BeanItemBudget;
import util.HibernateUtil;
@Repository
public class ItemBudgetDao implements IItemBudget {

	@Override
	public void additembudget(BeanItemBudget itembudget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(itembudget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanItemBudget Searchitembudget(int itembudgetId) {
		// TODO Auto-generated method stub
		BeanItemBudget result =new BeanItemBudget();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanItemBudget where itemBudgetId=?");
		qry.setParameter(0, itembudgetId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanItemBudget)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanItemBudget> loaditembudget(int itembudgetId) {
		// TODO Auto-generated method stub
		List<BeanItemBudget> result =new ArrayList<BeanItemBudget>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItemBudget");
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
	public List<BeanItemBudget> loadAllitembudgetbybudgetid() {
		// TODO Auto-generated method stub
		List<BeanItemBudget> result =new ArrayList<BeanItemBudget>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItemBudget where  ");
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
	public void modifryitembudget(BeanItemBudget itembudget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(itembudget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void Delitembudget(BeanItemBudget itembudget) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(itembudget);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
