package BankOperations;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class Operation {

	// Max number of customers 100
	String[] customers =new String[100]; 
	String[] accounts = new String[1000];
	
	short i = 0;
	String delimiter = ";";
	int minBal = 500;
	
	void loadData(String file1, String file2 ) {
		
		//System.out.println("file1 +  " " + file2);
				
		File customerFile = new File(file1);
		File acctFile = new File(file2);
		
		customers = loadDataFromFile(customerFile);
		accounts = loadDataFromFile(acctFile);
						
	}
	
	Customer getCustomerDetails(Long custId) {
		
		for(String customer : customers) {
			
			String[] str = customer.split(delimiter);
			
			Long cId = Long.parseLong(str[0]);   
			String fLname = str[1];
			String lName = str[2];
			String cAddress = str[3];
			
			if ( custId.equals(cId) ) {
				Customer cust = new Customer(custId);
				cust.setCustAddress(cAddress);
				cust.setFirstName(fLname);
				cust.setLastName(lName);
								
				return cust;
			}
		}
		return null;
	}
	
	Account getCustomerAccounts(Long custId) {
		
		for (String recd : accounts) {
			
			String[] recdStr = recd.split(delimiter);
			Long cId = Long.parseLong(recdStr[0]);
			String aId = recdStr[1];
			String type = recdStr[2];
			Long bal	= Long.parseLong(recdStr[3]);
			
			if ( custId.equals(cId) ) {
				
				Account acct = new Account(custId);
				acct.setAcctId(aId);
				acct.setAcctType(type);
				acct.setBalanceAmount(bal);
				acct.setMinBalRequired(minBal);								
				return acct;
			}
						
		}
		
		return null;
	}
	
	// Load the data from file into an array. 
	static String[] loadDataFromFile(File f) {
		
		Scanner s= null;
				
		short i=0;
		String[] retStr= new String[100000];
		
		try {
	        s = new Scanner (f);
	    	
	        while (s.hasNextLine()) {
	            	        	
	            String customer = s.nextLine(); 
	            retStr[i]  = customer;
	            
	                  	
	            //System.out.println("Customer" + customer );
	            i++;
	            	                     
	        }
	    } catch (IOException e) {
	        System.err.println(e);
	        System.exit(1);
	    }finally{
	    	s.close();
	    }
		return retStr;
	}
}
