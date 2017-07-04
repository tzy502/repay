package daoI;

import java.util.List;

import model.BeanTransterCard;

public interface ITransferCardDao {
	public void addTransferCard(BeanTransterCard Transfercard);
	//添加人卡对应�?
	
	public BeanTransterCard SearchTransferCard(int TransfercardId);
	//搜索人卡对应�?
	
	public BeanTransterCard loadTransferCard(int TransfercardId);
	//搜索人卡对应�?
	
	public List<BeanTransterCard> loadAllTransferCard();
	//搜索人卡对应�?
	
	public void modifryTransferCard(BeanTransterCard Transfercard);
	//修改人卡对应�?
	
	public void delTransferCard(BeanTransterCard Transfercard);
	//删除人卡对应�?
}
