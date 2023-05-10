package Dao;

import Entity.Customer;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public interface CustomerDAO {
	void login(String username, String password) 
			throws SomeThingWentWrongException, NoRecordFoundException;
	void addCustomer(Customer customer) throws SomeThingWentWrongException;
}
