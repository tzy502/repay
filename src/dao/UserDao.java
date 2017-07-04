package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import convenience.util.BaseException;
import convenience.util.HibernateUtil;
import daoI.IUser;
import model.BeanUser;

@Repository
public class UserDao implements IUser{
	public UserDao(){
	      System.out.println("UserDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addUser(BeanUser user) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public BeanUser SearchUser(String userId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanUser where userId = '" + userId + "'";
		Query qry = s.createQuery(hql);
		Object user = qry.uniqueResult();
		tx.commit();
		return (BeanUser)user;
	}



	@Override
	public BeanUser loadUser(String userId) {
		// TODO 自动生成的方法存根
		return null;
	}



	@Override
	public BeanUser loadAllUser() {
		// TODO 自动生成的方法存根
		return null;
	}



	@Override
	public void modifryUser(BeanUser user) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void DelUser(BeanUser user) {
		// TODO 自动生成的方法存根
		
	}

}
