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
    static void adminLogin(Scanner sc) throws SomeThingWentWrongException {
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
	private static void adminMenu(Scanner sc) throws SomeThingWentWrongException {
		int choice = 0;
		do {
			displayAdminMenu(sc);
//			System.out.print("Enter selection ");
//			choice = sc.nextInt();
			
	}while(choice!=0);
		}
	private static void displayAdminMenu(Scanner sc) throws SomeThingWentWrongException {
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
	private static void productManagement(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		 int ch=0;
		 do {
			   System.out.println("-------Menu-------");
	            System.out.println("1. Add Category");
	            System.out.println("2. Delete Category");
	            System.out.println("3. View All Categories");
	            System.out.println("4. Find Category by ID");
	            System.out.println("5. Add Product to Category");
	            System.out.println("6. Remove Product from Category");
	            System.out.println("7. View All Products");
	            System.out.println("8. Find Product by ID");
	            System.out.println("9. Calculate Total Cost of Products in Category");
	            System.out.println("10. View All Products By Category ");
	            System.out.println("0. Exit");
	            System.out.print("Enter Selection: ");
				ch=sc.nextInt();
				switch (ch) {
				case 1:
                    AdminUI.addCategory(sc);
                    break;
                case 2:
                    AdminUI.deleteCategory(sc);
                    break;
                case 3:
                   AdminUI.viewAllCategories();
                    break;
                case 4:
                	 AdminUI.findCategoryById(sc);
                    break;
                case 5:
                	 AdminUI.addProductToCategory(sc);
                    break;
                case 6:
                	 AdminUI.removeProductFromCategory(sc);
                    break;
                case 7:
                	 AdminUI.viewAllProducts(sc);
                    break;
                case 8:
                	 AdminUI.findProductById(sc);
                
                    break;
                case 9:
                	 AdminUI.calculateTotalCostOfProductsInCategory(sc);
                    break;
                case 10:
               	 AdminUI.viewAllProductsInCategory(sc);
                   break; 
                case 0:
                    System.out.println("Exiting program...");
                    break;
				default:
					   System.out.println("Invalid selection. Please try again.");
					break;
				}	
			
		} while (ch!=0);
	}
	private static void orderManagement(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void CustomerManagement(Scanner sc) throws SomeThingWentWrongException {
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
