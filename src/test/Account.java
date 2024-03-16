package test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
public class Account {
	int balance;
	int prevTransaction;
	String customerName;
	String customerID;
	

	Account(String cn, String ci) {
		customerID = ci;
		customerName = cn;
	}
	
	void deposit(int amount) {
		if (amount != 0 && amount > 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
	}
	
	void getPrevTransaction() {
		if (prevTransaction > 0) {
			System.out.println("Deposited: " + prevTransaction);
		} else if (prevTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(prevTransaction));
		} else {
			System.out.println("No Transaction Occured!");
		}
	}
	
	void showMenu() {
		char option = '\0';
		
		showDate();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome dear, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("what do u want?");
		System.out.println();
		System.out.println("A. Check Your Balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdraw");
		System.out.println("D. View Perv Transaction");
		System.out.println("E. Exit");

	
	do {
		System.out.println();
		System.out.println("Please enter an option: ");
		char option1 = scanner.next().charAt(0);
		option = Character.toUpperCase(option1);
		System.out.println();
		
		switch(option) {
		case 'A':
			System.out.println("=================");
			System.out.println("Balance = $" + balance);
			System.out.println("=================");
			break;
		case 'B':
			System.out.println("Enter an amount to deposit: ");
			int amount = scanner.nextInt();
			deposit(amount);
			break;
		case 'C':
			System.out.println("Enter an amount to Withdraw: ");
			int amount2 = scanner.nextInt();
			withdraw(amount2);
			break;
		case 'D':
			System.out.println("==============");
			getPrevTransaction();
			System.out.println("==============");
			break;
		case 'E':
			System.out.println("=========");
			break;
		default:
			System.out.println("Error: Invalid Option. Please Enter A,B,C,D");
			break;
		}
	} while (option != 'E');
	System.out.println("Thanks for your patience");
	
}
	static void showDate() {
		 LocalDate tadayshamsi = LocalDate.now();
		 DateTimeFormatter saraformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd (EEEE)", new Locale("fa", "IR"));
	        String formattedDate = tadayshamsi.format(saraformatter);
	        
	        System.out.println("Date and Day: " + formattedDate);
	}
}
