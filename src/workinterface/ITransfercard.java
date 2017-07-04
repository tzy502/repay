package workinterface;

import model.BeanTransterCard;

public interface ITransfercard {
	public void addTransfercard(BeanTransterCard Transfercard);
	//添加人卡对应表
	public BeanTransterCard SearchTransfercard(int TransfercardId);
	//搜索人卡对应表
	public BeanTransterCard loadTransfercard(int TransfercardId);
	//搜索人卡对应表
	public BeanTransterCard loadAllTransfercard();
	//搜索人卡对应表
	public void modifryTransfercard(BeanTransterCard Transfercard);
	//修改人卡对应表
	public void DelTransfercard(BeanTransterCard Transfercard);
	//删除人卡对应表
}
