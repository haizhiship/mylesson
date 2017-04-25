package ch8.proxyfactory;

public class UserServiceImpl {
	private String txId;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public void updateUser() {
		System.out.println(txId + ":$$$$Ö´ÐÐÒµÎñÂß¼­$$$$");
	}

}
