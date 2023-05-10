package Dao;

import java.util.List;

import Entity.Customer;
import Entity.LoggedInUserId;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.transaction.Transaction;

public class CustomerDAOImpl implements CustomerDAO{

	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT c.id FROM Customer c WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			if(listInt.size() == 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		EntityManager em = null;// TODO Auto-generated method stub
		try {
			em=EMUtils.getEntityManager();
			Query query=em.createQuery("SELECT COUNT(c) FROM Customer c where username=:username");
			query.setParameter("username", customer.getUsername());
			if((Long)query.getSingleResult()>0) {
				System.out.println("The username" + customer.getUsername() + " is already Registered");
				throw new SomeThingWentWrongException("The username" + customer.getUsername() + " is already Registered");
			}
			EntityTransaction tx=em.getTransaction();
			  tx.begin();
			  em.persist(customer);
			  tx.commit();
			
		} catch (Exception e) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			 if (em != null) {
			        em.close();
			    }
		}
	}

}
