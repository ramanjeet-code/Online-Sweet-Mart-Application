package Dao;

import java.util.List;

import Entity.Category;
import Entity.Product;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(Long productId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		
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

}
