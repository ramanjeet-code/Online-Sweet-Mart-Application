package Service;

import java.util.ArrayList;
import java.util.List;

import Dao.productDao;
import Dao.productDaoImpl;
import Entity.Category;
import Entity.Product;
import Exception.SomeThingWentWrongException;

public class ProductServiceImpl implements ProductService {

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		if(product==null) {
			throw new SomeThingWentWrongException("Please Add details");
		}
		productDao pd=new productDaoImpl();
		pd.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		productDao pd=new productDaoImpl();
		pd.updateProduct(product);
	}

	@Override
	public void deleteProductById(Long productId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		productDao pd=new productDaoImpl();
		pd.deleteProductById(productId);
	}

	@Override
	public List<Product> findAllProducts() throws SomeThingWentWrongException {
		 List<Product> productList = new ArrayList<>();
			productDao pd=new productDaoImpl();
		    try {
		        productList = pd.findAllProducts();
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Unable to process request, try again later"+e);
		    }
		    return productList;
	}

	@Override
	public Product findProductById(Long productId) throws SomeThingWentWrongException {
		productDao pd=new productDaoImpl();
		Product pr=pd.findProductById(productId);
		return pr;
	}

	@Override
	public List<Product> getAllProductsByCategory(Category category) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		productDao pd=new productDaoImpl();
		try {
	        return pd.getAllProductsByCategory(category);
	    } catch (Exception e) {
	        throw new SomeThingWentWrongException("Unable to process request, try again later"+ e);
	    }
		
	}

	@Override
	public List<Product> findProductsByName(String name) throws SomeThingWentWrongException {
		productDao pd=new productDaoImpl();  
		List<Product> products=pd.findProductsByName(name);
		return products;
	}

}
