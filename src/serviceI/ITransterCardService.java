package serviceI;

import java.util.List;

import model.BeanTransterCard;
import util.BaseException;

public interface ITransterCardService {
	public void addTransterCard(int repayId,String transferCardFees,String user)throws BaseException; 
	public void modifryTransterCard( int transferCardId,int repayId,String transferCardFees,String user)throws BaseException;
	public void delTransterCard( int transferCardId)throws BaseException;
	public BeanTransterCard searchTransterCard( int transferCardId,int repayId) throws BaseException;
	public List<BeanTransterCard> loadTransterCard() throws BaseException;
}
