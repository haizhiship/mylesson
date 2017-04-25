package ch8.proxyfactorybean;

import org.springframework.stereotype.Component;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
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
