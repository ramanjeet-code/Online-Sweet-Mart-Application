package Ui.gabby_cough_15;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Entity.Customer;
import Entity.Product;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import Service.CustomerService;
import Service.CustomerServiceImpl;
import Service.ProductService;
import Service.ProductServiceImpl;


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


	private static void userMenu(Scanner sc) throws SomeThingWentWrongException {
		int ch=0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			ch= sc.nextInt();
			switch (ch) {
			case 1: 
				 AdminUI.viewAllProducts(sc);
				 break;
			case 2:
				findProductsByName(sc);
			case 3:
				
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		} while (ch!=0);
		
	}
	private static void findProductsByName(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		String name=sc.next();
		ProductService pd=new ProductServiceImpl();
		List<Product>list= pd.findProductsByName(name);
		for (Product product : list) {
		    System.out.println("Product ID: " + product.getProductId());
		    System.out.println("Name: " + product.getName());
		    System.out.println("Photo Path: " + product.getPhotoPath());
		    System.out.println("Price: " + product.getPrice());
		    System.out.println("Description: " + product.getDescription());
		    System.out.println("Available: " + product.getAvailable());
		    System.out.println("Category: " + product.getCategory().getName());
		    System.out.println("------------------------");
		}
	}


	static void displayUserMenu() {
		System.out.println("1.View All Products");
		System.out.println("2.Seach Product  ");
		System.out.println("3. Buy Product");
		System.out.println("4. Purchase a Product");
		System.out.println("5. Change Password");
		System.out.println("6. Delete Account");
		System.out.println("0. Logout");
	}
}
