package Dao;

import java.util.List;

import Entity.Category;
import Entity.Product;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class productDaoImpl implements productDao {

	public productDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em=EMUtils.getEntityManager();
//			Query query=em.createQuery("SELECT COUNT(c) FROM Customer c where name=:name");
//			query.setParameter("name", product.getName());
//			if((Long)query.getSingleResult()>0) {
//				System.out.println("The username" +  product.getName() + " is already Registered");
//				throw new SomeThingWentWrongException("The username" +  product.getName() + " is already Registered");
//			}
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(product);
             tx.commit();
		  } catch (Exception e) {
				throw new SomeThingWentWrongException("Unable to process request, try again later"+e);
			}finally{
				 if (em != null) {
				        em.close();
				    }
			}
	}

	@Override
	public void updateProduct(Product product) throws SomeThingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();
	    try {
	        em.getTransaction().begin();
	        Product existingProduct = em.find(Product.class, product.getProductId());
	        if (existingProduct == null) {
	            throw new SomeThingWentWrongException("Product not found with id: " + product.getProductId());
	        }
	        existingProduct.setName(product.getName());
	        existingProduct.setPhotoPath(product.getPhotoPath());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setDescription(product.getDescription());
	        existingProduct.setAvailable(product.getAvailable());
	        existingProduct.setCategory(product.getCategory());
	        existingProduct.setQuantity(product.getQuantity());
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Unable to update product: " + e.getMessage());
	    } finally {
	        em.close();
	    }
		
	}

	@Override
	public void deleteProductById(Long productId) throws SomeThingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();
	    try {
	        em.getTransaction().begin();
	        Product product = em.find(Product.class, productId);
	        if (product == null) {
	            throw new SomeThingWentWrongException("Product not found with id: " + productId);
	        }
	        em.remove(product);
	        em.getTransaction().commit();
	        System.out.println("Succefull Deleted");
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Unable to delete product with id: " + productId + " " + e.getMessage());
	    } finally {
	        em.close();
	    }
	    
}

	@Override
	public List<Product> findAllProducts() throws SomeThingWentWrongException {
		  EntityManager em = EMUtils.getEntityManager();
		    try {
		        Query query = em.createQuery("FROM Product");
		        List<Product> productList = query.getResultList();
		        return productList;
		    } finally {
		        em.close();
		    }
	}

	@Override
	public Product findProductById(Long productId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		  EntityManager em = EMUtils.getEntityManager();
		    try {
		        Product product = em.find(Product.class, productId);
		        if (product == null) {
		            throw new SomeThingWentWrongException("Product not found with id: " + productId);
		        }
		        product.getCategory().getName(); 
		        return product;
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Unable to find product with id: " + productId+ e);
		    } finally {
		       em.close();
		    }
	}

	@Override
	public List<Product> getAllProductsByCategory(Category category) throws SomeThingWentWrongException {
		  EntityManager em = null;
		    try {
		        em = EMUtils.getEntityManager();
		        Query query = em.createQuery("SELECT p FROM Product p WHERE p.category = :category");
		        query.setParameter("category", category);
		        return query.getResultList();
		    } finally {
		        if (em != null) {
		            em.close();
		        }
		    }
	}

	@Override
	public List<Product> findProductsByName(String input) throws SomeThingWentWrongException {
		 EntityManager em = EMUtils.getEntityManager();
		    try {
		        String queryStr = "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:input)";
		        TypedQuery<Product> query = em.createQuery(queryStr, Product.class);
		        query.setParameter("input", "%" + input + "%");
		        List<Product> products = query.getResultList();
		        if (products.isEmpty()) {
		            throw new SomeThingWentWrongException("No products found with name containing: " + input);
		        }
		        return products;
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Unable to find products with name containing: " + input + e);
		    } finally {
		       em.close();
		    }
	
	}

}
