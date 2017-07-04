package daoI;

import model.BeanTransterCard;

public interface ITransfercard {
	public void addTransfercard(BeanTransterCard Transfercard);
	//添加人卡对应�?
	public BeanTransterCard SearchTransfercard(int TransfercardId);
	//搜索人卡对应�?
	public BeanTransterCard loadTransfercard(int TransfercardId);
	//搜索人卡对应�?
	public BeanTransterCard loadAllTransfercard();
	//搜索人卡对应�?
	public void modifryTransfercard(BeanTransterCard Transfercard);
	//修改人卡对应�?
	public void DelTransfercard(BeanTransterCard Transfercard);
	//删除人卡对应�?
}
