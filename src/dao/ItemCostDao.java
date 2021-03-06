package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IItemCost;
import model.BeanBudget;
import model.BeanItemCost;
import model.BeanUser;
import util.HibernateUtil;
@Repository
public class ItemCostDao implements IItemCost {

	@Override
	public void additemcost(BeanItemCost itemcost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(itemcost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanItemCost Searchitemcost(int itemcostId) {
		// TODO Auto-generated method stub
		BeanItemCost result =new BeanItemCost();
		result=null;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanItemCost where itemCostId=?");
		qry.setParameter(0, itemcostId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanItemCost)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanItemCost> loaditemcost(int itemcostId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<BeanItemCost> result =new ArrayList<BeanItemCost>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItemCost");
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
	public List<BeanItemCost> loadAllitemcost() {
		// TODO Auto-generated method stub
		List<BeanItemCost> result =new ArrayList<BeanItemCost>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItemCost");
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
	public void modifryitemcost(BeanItemCost itemcost) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(itemcost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void Delitemcost(BeanItemCost itemcost) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(itemcost);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<BeanItemCost> loadItemcostBySId(int summaryId) {
		// TODO 自动生成的方法存根
		List<BeanItemCost> result =new ArrayList<BeanItemCost>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanItemCost where summaryId = "+summaryId+"");
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
	public double searchSumGB(int summaryId, int oItemId) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "select sum(itemCost) from BeanItemCost where summaryId = "+summaryId+" and oItemId = "+oItemId+" group by oItemId";
		Query qry = session.createQuery(hql);
		Object result = qry.uniqueResult();
		tx.commit();
		if(result != null)
			return (double) result;
		else
			return 0;
	}

}
