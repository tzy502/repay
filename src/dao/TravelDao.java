package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITravelDao;
import model.BeanBudget;
import model.BeanTravel;
import util.HibernateUtil;
@Repository
public class TravelDao implements ITravelDao{
	public TravelDao(){
		System.out.println("TravelDao Constructor...\n\n\n\n\n");
	}
	
	
	@Override
	public void addTravel(BeanTravel travel) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(travel);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTravel SearchTravel(int travelId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTravel where travelId = '" + travelId + "'";
		Query qry = s.createQuery(hql);
		Object travel = qry.uniqueResult();
		tx.commit();
		return (BeanTravel)travel;
	}

	@Override
	public List<BeanTravel> loadAllTravel() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTravel ";
		hql += " order by travelId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTravel> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTravel(BeanTravel travel) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(travel);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delTravel(BeanTravel travel) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(travel);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}


	@Override
	public int TravelmaxId() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "select max(travelId) from BeanTravel";
		Query qry = s.createQuery(hql);
		java.util.List<Integer> list=qry.list(); 
		int maxid=list.get(0);
		tx.commit();
		return maxid;
	}


	@Override
	public List<BeanTravel> SearchTravelbyrepayid(int repayid) {
		List<BeanTravel> result =new ArrayList<BeanTravel>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanTravel where repayid=?");
			qry.setParameter(0, repayid);
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

}
