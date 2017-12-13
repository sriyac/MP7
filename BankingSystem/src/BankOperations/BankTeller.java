package BankOperations;

import java.util.Scanner;

public class BankTeller {

	static String mainHeader = null;
	static char custType='N';
	
	static Customer currCustomer = null;
	static Account  acctCurrCustomer = null;
	
	static Long numOfCustomers = 0L;
	
	
	public static void main(String[] args) {
		
		
		mainHeader = args[0];
		
		
		
		long id = Long.parseLong(args[1]);     
		 
		
		
		String customerFile = "CustomersData.txt";
		String accountsFile = "AccountsData.txt";
		
		Operation ops = new Operation();
		ops.loadData(customerFile, accountsFile);
		
		currCustomer = ops.getCustomerDetails(id);
		acctCurrCustomer = ops.getCustomerAccounts(id);
		
		
		displayMainMenu();
		
		// UI starts!!
		String opt=null;
		Scanner sc = new Scanner(System.in);
		char optChar;
		do {
			
			System.out.println("");
			
			opt=sc.next();
			
			optChar = opt.charAt(0);
			
			switch (optChar) {
			
			case('I'):
			case('i'):
				
				System.out.println("\n");
				System.out.println("****************************\n");
				System.out.println("Details of Customer: \n");
				System.out.println(currCustomer.toString());
				
				System.out.println("$$$$$$$\n");
				System.out.println("Details of Customer Account: \n");
				System.out.println(acctCurrCustomer.toString());
				
				System.out.println("****************************\n");
				
				displayMainMenu();
				break;
			case('W'):
			case('w'):
				System.out.print("\n Please enter Amount: \n");
				int amt = sc.nextInt();
				System.out.println("AMount: " + amt);
				acctCurrCustomer.subtractAmount(amt);
				if (acctCurrCustomer.getBalanceAmount() < acctCurrCustomer.getMinBalRequired() ) {
					System.out.println( "Minimum balance required is:" 
				                        + acctCurrCustomer.getMinBalRequired() 
				                        + "  Failed this requirement!");
				}
				displayMainMenu();
				break;
			
			case('D'):
			case('d'):
				System.out.println("\n Please enter Amount: \n");
				int depAmount = sc.nextInt();
				System.out.println("AMount: " + depAmount);
				acctCurrCustomer.addAmount(depAmount);
				displayMainMenu();
				break;
			case('E'):
			case('e'):System.out.println("Thank you.. Exiting!! \n");
				break;
				
			default: 
				System.out.println("Invalid Option. Please Try again!");
				displayMainMenu();
			break;
			}
		}while ( (optChar != 'E') && ( optChar != 'e') );

		sc.close();
		
	}
	
	static void displayMainMenu() {
		
		System.out.println("****************************");
		System.out.println("** Welcome to " + mainHeader +"**");
		System.out.println("Please type in");
		System.out.println("I or i to inquire account details.");
		System.out.println("W or w to withdraw cash.");
		System.out.println("D or d to deposit.");
		System.out.println("E or e for Exiting the System!");
		System.out.println("****************************");
		System.out.print("\n");
		
	}
}
