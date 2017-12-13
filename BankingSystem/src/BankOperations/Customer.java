package BankOperations;

import java.util.Arrays;

public class Customer {

	String lastName =null;
	String firstName=null;
	
	long	custId =0L;
	String  custAddress=null;
	
			
	Customer(long id) {
		
		custId = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	


	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + ", firstName=" + firstName + ", custId=" + custId + ", custAddress="
				+ custAddress + ", "  + "]";
	}
	
	
}
