package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IProject;
import model.BeanProject;
import model.BeanUser;
import util.HibernateUtil;
@Repository
public class ProjectDao implements IProject{
	public ProjectDao(){
	      System.out.println("ProjectDao Constructor...\n\n\n\n\n");
	}
	@Override
	public void addProject(BeanProject project) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void updateProject(BeanProject project) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delProject(BeanProject project) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public List<BeanProject> loadAllProject() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanProject ";
		hql += " order by projectId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanProject> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public BeanProject searchProject(int projectId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanProject where projectId = '" + projectId + "'";
		Query qry = s.createQuery(hql);
		Object project = qry.uniqueResult();
		tx.commit();
		return (BeanProject)project;
	}
	@Override
	public List<BeanProject> searchBudgetProject() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanProject ";
		hql += " where isBudget = 0";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanProject> result = qry.list();
		tx.commit();
		return result;
	}

}
