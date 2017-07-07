package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.ITravelUserDao;
import model.BeanTravelUser;
import util.HibernateUtil;
@Repository
public class TravelUserDao implements ITravelUserDao{
	public TravelUserDao(){
		System.out.println("TravelUserDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addTravelUser(BeanTravelUser TravelUser) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(TravelUser);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTravelUser SearchTravelUser(int TravelUserId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTravelUser where TravelUserId = '" + TravelUserId + "'";
		Query qry = s.createQuery(hql);
		Object travelUser = qry.uniqueResult();
		tx.commit();
		return (BeanTravelUser)travelUser;
	}



	@Override
	public List<BeanTravelUser> loadAllTravelUser() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTravelUser ";
		hql += " order by travelUserId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTravelUser> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTravelUser(BeanTravelUser TravelUser) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(TravelUser);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delTravelUser(BeanTravelUser TravelUser) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(TravelUser);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
}
