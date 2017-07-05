package service;

import java.util.List;

import model.BeanTransterCard;
import serviceI.ITransterCardService;
import util.BaseException;

public class TransterCardService implements ITransterCardService {

	@Override
	public void addTransterCard(int repayId, String transferCardFees,String userid) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifryTransterCard(int transferCardId, int repayId, String transferCardFees,String userid) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delTransterCard(int transferCardId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanTransterCard searchTransterCard(int transferCardId, int repayId) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanTransterCard> loadTransterCard() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
