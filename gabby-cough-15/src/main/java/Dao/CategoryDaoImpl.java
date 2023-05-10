package Dao;

import java.util.List;

import Entity.Category;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CategoryDaoImpl implements CategoryDao {

	public CategoryDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addcategory(Category category) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em=EMUtils.getEntityManager();
			Query query=em.createQuery("SELECT COUNT(c) FROM Category c where name=:name");
			query.setParameter("name", category.getName());
			if((Long)query.getSingleResult()>0) {
				System.out.println("The Categoryname" + category.getName() + " is already Added");
				throw new SomeThingWentWrongException("The username" +category.getName() + " is already Added");
			}
			EntityTransaction tx=em.getTransaction();
			  tx.begin();
			  em.persist(category);
			  tx.commit();
			  System.out.println("Category Scucefully Addded");
		} catch (Exception e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			 if (em != null) {
			        em.close();
			    }
		}	
	}

	@Override
	public void deleteCategory(int id) throws SomeThingWentWrongException {
		EntityManager em = EMUtils.getEntityManager();
	    try {
	        em.getTransaction().begin();
	        Category category = em.find(Category.class, id);
	        if (category == null) {
	            throw new SomeThingWentWrongException("Category not found with id: " + id);
	        }
	        em.remove(category);
	        em.getTransaction().commit();
	        System.out.println("Deleted Suceefully");
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        throw new SomeThingWentWrongException("Unable to delete category with id: " + id + e);
	    } finally {
	        em.close();
	    }		
	}

	@Override
	public List<Category> getAllCategories() throws SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em=EMUtils.getEntityManager();
			Query q=em.createQuery("SELECT c FROM Category c");
			List<Category> list=q.getResultList();
			return list;
		} catch (Exception e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later"+e);
		}
		finally {
		    if (em != null) {
		        em.close();
		    }
		}
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateTotalCost(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category findCategoryById(Long categoryId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em=EMUtils.getEntityManager();
			Category category=em.find(Category.class, categoryId);
			   if(category == null) {
		            throw new NoRecordFoundException("Category with id " + categoryId + " not found");
		        }
		        return category;
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Unable to process request, try again later"+ e);
		    } finally {
		        if(em != null) {
		            em.close();
		        }
		    }

}
	}
