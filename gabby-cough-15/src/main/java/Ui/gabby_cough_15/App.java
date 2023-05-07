package Ui.gabby_cough_15;

import java.util.Scanner;

import Exception.SomeThingWentWrongException;



/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws SomeThingWentWrongException
    {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    			//	do{System.out.println("ProgramEnded...");}while(true);
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    
    }
    static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	private static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu(sc);
//			System.out.print("Enter selection ");
//			choice = sc.nextInt();
			
	}while(choice!=0);
		}
	private static void displayAdminMenu(Scanner sc) {
		// TODO Auto-generated method stub
		int ch=0;
		
		System.out.println("1. Customer Management");
		System.out.println("2. Order Managerment");
		System.out.println("3. Product Management");
		System.out.println("0. Exit");
		System.out.print("Enter Selection ");
           ch=sc.nextInt();
           switch (ch) {
		   case 1:CustomerManagement(sc);
		    break;
		   case 2:orderManagement(sc);
		   break;
		   case 3:productManagement(sc);
		   break;
		   case 0:
				System.out.println("Thanks for using the services");
				break;
		

		default:
			break;
		}
		
	}
	private static void productManagement(Scanner sc) {
		// TODO Auto-generated method stub
		 int ch=0;
		 do {
			 System.out.println("1. Add Products");
				System.out.println("2. Delete Products");
				System.out.println("3. view All Products");
				System.out.println("4.Find product by Id");
				System.out.println("0. Exit");
				System.out.print("Enter Selection ");
				ch=sc.nextInt();
				switch (ch) {
				case 1:
					AdminUI.AddProduct(sc);
					
					break;
				  case 0:
						System.out.println("Thanks for using the services");
						break;
				default:
					break;
				}	
			
		} while (ch!=0);
	}
	private static void orderManagement(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void CustomerManagement(Scanner sc) {
		int ch=0;
		do {
			System.out.println("1. View Customers");
			System.out.println("2. Delete Customers");
			System.out.println("3. Update Customers");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			ch=sc.nextInt();
			switch (ch) {
			case 1:
				AdminUI.viewAllCustomers();
				
				break;
			  case 0:
					System.out.println("Thanks for using the services");
					displayAdminMenu(sc);
					break;
			default:
				break;
			}
			
		} while (ch!=0);
		
		
	}
	private static void viewAllCustomers() {
		// TODO Auto-generated method stub
		
	}
}
