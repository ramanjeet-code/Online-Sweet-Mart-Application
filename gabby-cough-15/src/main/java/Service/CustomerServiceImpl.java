package Service;

import Dao.CustomerDAO;
import Dao.CustomerDAOImpl;
import Entity.Customer;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl () {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.login(username, password);		
		
	}

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		customerDAO.addCustomer(customer);
		
	}

}
