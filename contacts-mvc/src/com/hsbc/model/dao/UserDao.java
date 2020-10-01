package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserDao {
	
	//login
	public User authenticate(int userId, String password) throws AuthenticationException;
	//register
	public User storeUser(User user);
	
	public List<User> fetchAllUsers();
	//edit profile
	public User updateUser(int userId, User user);
	//view contact
	public List<Contact> fetchAllContacts(int userId);
	//add contact
	public Contact storeContact(int userId,Contact contact);
	//edit contact
	public Contact updateContact(int contactId,String contactName,long contactPhone);
	//delete contact
	public boolean  deleteContact(Contact contact);
	//delete profile
	public boolean deleteUser(int userId);
	
	//logout

}
