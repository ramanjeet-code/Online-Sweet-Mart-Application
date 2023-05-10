package Service;

import Entity.Customer;
import Exception.*;

public interface CustomerService {
	void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException;
	
	void addCustomer(Customer customer) throws SomeThingWentWrongException;
}
