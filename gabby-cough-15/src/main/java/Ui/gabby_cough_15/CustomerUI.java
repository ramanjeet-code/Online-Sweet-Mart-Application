package Ui.gabby_cough_15;

import java.time.LocalDate;
import java.util.Scanner;

import Entity.Customer;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import Service.CustomerService;
import Service.CustomerServiceImpl;


public class CustomerUI {

	public CustomerUI() {
		// TODO Auto-generated constructor stub
	}


	static void customerRegistration(Scanner sc) throws SomeThingWentWrongException {
		//code to take input
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		System.out.print("Email ");
		String email=sc.next();
		
		//Create an object of customer
		Customer customer = new Customer(name, username, password, dateOfBirth, email, 0);
		
		//Create an object of CustomerService
		CustomerService customerService = new CustomerServiceImpl();
		customerService.addCustomer(customer);
		System.out.println("Customer added successfully");
	}
	static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}


	private static void userMenu(Scanner sc) {
		int ch=0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			ch= sc.nextInt();
		} while (ch!=0);
		
	}
	static void displayUserMenu() {
		System.out.println("1.Seach Product ");
		System.out.println("2. Buy Product");
		System.out.println("3. Purchase a Product");
		System.out.println("4. Change Password");
		System.out.println("5. Delete Account");
		System.out.println("0. Logout");
	}
}
