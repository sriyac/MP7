package BankOperations;

import java.util.Arrays;

public class Account {

	long custId=0L;
	String acctId =null;
	
	Long balanceAmount=0L;
	String acctType = null;
	int minBalRequired = 0;
	
	Account(long id) {
		
		custId = id;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public Long getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balanceAmount=" + balanceAmount + ", acctType="
				+ acctType + "]";
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public void addAmount(int amt) {
		
		balanceAmount = balanceAmount + amt;
	}
	
	public void subtractAmount(int amt) {
		
		balanceAmount = balanceAmount - amt;
	}

	public int getMinBalRequired() {
		return minBalRequired;
	}

	public void setMinBalRequired(int minBalRequired) {
		this.minBalRequired = minBalRequired;
	}
}
