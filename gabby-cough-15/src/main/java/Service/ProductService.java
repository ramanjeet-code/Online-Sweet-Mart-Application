package Service;

import java.util.List;

import Entity.Category;
import Entity.Product;
import Exception.SomeThingWentWrongException;

public interface ProductService {


	   void addProduct(Product product) throws SomeThingWentWrongException;
	    void updateProduct(Product product) throws SomeThingWentWrongException;
	    void deleteProductById(Long productId) throws SomeThingWentWrongException;
	    List<Product> findAllProducts() throws SomeThingWentWrongException;
	    Product findProductById(Long productId) throws SomeThingWentWrongException;
	    List<Product> getAllProductsByCategory(Category category) throws SomeThingWentWrongException;

}
