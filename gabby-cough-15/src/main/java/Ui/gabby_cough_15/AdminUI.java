package Ui.gabby_cough_15;

import java.util.List;
import java.util.Scanner;

import Entity.Category;
import Entity.Product;
import Exception.SomeThingWentWrongException;
import Service.CategoryService;
import Service.CategoryServiceImpl;
import Service.ProductService;
import Service.ProductServiceImpl;

public class AdminUI {

	public AdminUI() {
		// TODO Auto-generated constructor stub
	}

	public static void viewAllCustomers() {
		// TODO Auto-generated method stub
		
	}

	public static void addCategory(Scanner sc) throws SomeThingWentWrongException {
		 System.out.print("Enter category name: ");
	        String name = sc.next();
	        Category cat=new Category(name, null);
	        CategoryService c=new CategoryServiceImpl();
	        c.addcategory(cat);
	}

	public static void deleteCategory(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter CategoryId");
		  int categoryId = sc.nextInt();
			 CategoryService c=new CategoryServiceImpl();
			 c.deleteCategory(categoryId);
			 
	}

	public static void viewAllCategories() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		 CategoryService c=new CategoryServiceImpl();
		List<Category> categories=c.getAllCategories();
		 if (categories.isEmpty()) {
		        System.out.println("No categories found.");
		        return;
		    }
		    
		    System.out.println("All Categories:");
		    for (Category category : categories) {
		        System.out.println("ID: " + category.getCategoryId() + ", Name: " + category.getName());
		    }
	}

	public static void findCategoryById(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void addProductToCategory(Scanner sc) throws SomeThingWentWrongException {
		  System.out.print("Enter category ID: ");
		    Long categoryId = sc.nextLong();
		    CategoryService categoryService = new CategoryServiceImpl();
		    Category category = categoryService.findCategoryById(categoryId);

		    if (category == null) {
		        System.out.println("Category with ID " + categoryId + " does not exist.");
		        return;
		    }

		    System.out.print("Enter product name: ");
		    String name = sc.next();

		    System.out.print("Enter product photo path: ");
		    String photoPath = sc.next();

		    System.out.print("Enter product price: ");
		    Double price = sc.nextDouble();

		    System.out.print("Enter product description: ");
		    String description = sc.next();
		    System.out.print("Enter product Quantity: ");
		    int q=sc.nextInt();
		    Product product = new Product();
		    product.setName(name);
		    product.setPhotoPath(photoPath);
		    product.setPrice(price);
		    product.setDescription(description);
		    product.setAvailable(true);
		    product.setCategory(category);
            product.setQuantity(q);
		    ProductService productService = new ProductServiceImpl();
		    productService.addProduct(product);

		    System.out.println("Product added successfully to category " + category.getName());

		
	}

	public static void removeProductFromCategory(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter ProductID");
		Long productId=sc.nextLong();
		 ProductService productService = new ProductServiceImpl();
		 productService.deleteProductById(productId);
	}

	public static void viewAllProducts(Scanner sc) throws SomeThingWentWrongException {
	
		    ProductService productService = new ProductServiceImpl();
		    List<Product> productList=productService.findAllProducts();
		    for (Product product : productList) {
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Product name: " + product.getName());
                System.out.println("Product photo path: " + product.getPhotoPath());
                System.out.println("Product price: " + product.getPrice());
                System.out.println("Product description: " + product.getDescription());
                System.out.println("Product availability: " + product.getAvailable());
                System.out.println("Product Quantity: " + product.getQuantity());
                System.out.println();
            }
	}


	public static void calculateTotalCostOfProductsInCategory(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void viewAllProductsInCategory(Scanner sc) throws SomeThingWentWrongException {
		//Category category=new Category();
		  ProductService productService = new ProductServiceImpl();
		  CategoryService cat=new CategoryServiceImpl();
		  System.out.print("Enter category ID : ");
		   Long categoryId=sc.nextLong();
		    
		    // Find category by ID or name
		    Category category = null;
		    category = cat.findCategoryById(categoryId);
		    
		    
		    if (category == null) {
		        System.out.println("Category not found.");
		        
		    }
		    
		    // Get all products in the category and print them
		    List<Product> products = productService.getAllProductsByCategory(category);
		    if (products.isEmpty()) {
		        System.out.println("No products found in the category.");
		    } else {
		        System.out.println("Products in category " + category.getName() + ":");
		        for (Product product : products) {
		            System.out.println(product.getName() + " (" + product.getPrice() + ")");
		        }
		    }
		}

	public static void findProductById(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		 System.out.println("Enter ProductId");
		 Long id=sc.nextLong();
		  ProductService productService = new ProductServiceImpl();
		 Product pr= productService.findProductById(id);
		 System.out.println(pr.toString());
	}

	public static void updateProdyctById(Scanner sc) {
		 try {
		        ProductService productService = new ProductServiceImpl();
		        System.out.print("Enter the product ID: ");
		        Long productId = sc.nextLong();
		        Product product = productService.findProductById(productId);
		        if (product == null) {
		            System.out.println("Product not found with ID: " + productId);
		            return;
		        }
		        System.out.print("Enter the new name: ");
		        String name = sc.next();
		        System.out.print("Enter the new photo path: ");
		        String photoPath = sc.next();
		        System.out.print("Enter the new price: ");
		        Double price = sc.nextDouble();
		        System.out.print("Enter the new description: ");
		        String description = sc.next();
		        System.out.print("Enter product Quantity: ");
			    int q=sc.nextInt();
		        System.out.print("Enter the new availability (true/false): ");
		        Boolean available = sc.nextBoolean();
		        System.out.print("Enter the new category ID: ");
		        int categoryId = sc.nextInt();
		        Category category = new Category();
		        category.setCategoryId(categoryId);
		        product.setName(name);
		        product.setPhotoPath(photoPath);
		        product.setPrice(price);
		        product.setDescription(description);
		        product.setAvailable(available);
		        product.setCategory(category);
		        product.setQuantity(q);
		        productService.updateProduct(product);
		        System.out.println("Product updated successfully!");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Error: " + e.getMessage());
		    }
		
	}
		
	

}
