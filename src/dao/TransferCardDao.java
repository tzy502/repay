package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import convenience.util.HibernateUtil;
import daoI.ITransferCardDao;
import model.BeanTransterCard;

public class TransferCardDao implements ITransferCardDao{
	public TransferCardDao(){
		System.out.println("TransferCardDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addTransferCard(BeanTransterCard TransferCard) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(TransferCard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanTransterCard SearchTransferCard(int TransferCardId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanTransterCard where TransferCardId = '" + TransferCardId + "'";
		Query qry = s.createQuery(hql);
		Object transterCard = qry.uniqueResult();
		tx.commit();
		return (BeanTransterCard)transterCard;
	}

	@Override
	public BeanTransterCard loadTransferCard(int TransferCardId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<BeanTransterCard> loadAllTransferCard() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanTransterCard ";
		hql += " order by transterCardId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanTransterCard> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryTransferCard(BeanTransterCard TransferCard) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(TransferCard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delTransferCard(BeanTransterCard TransferCard) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(TransferCard);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
