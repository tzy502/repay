package workinterface;

public interface ITransfercard {
	public void addTransfercard(BeanTransfercard Transfercard);
	//添加人卡对应表
	public BeanTransfercard SearchTransfercard(int TransfercardId);
	//搜索人卡对应表
	public BeanTransfercard loadTransfercard(int TransfercardId);
	//搜索人卡对应表
	public BeanTransfercard loadAllTransfercard();
	//搜索人卡对应表
	public void modifryTransfercard(BeanTransfercard Transfercard);
	//修改人卡对应表
	public void DelTransfercard(BeanTransfercard Transfercard);
	//删除人卡对应表
}
