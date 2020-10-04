package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserService {
	
	//login
		public User login(int userId, String password) throws AuthenticationException;
		//register
		public User createUser(User user);
		
		public List<User> fetchAllUsers();
		public User getUser(int userId);
		
		//edit profile
		public User updatePassword(int userId, String password);
		public User updatePhone(int userId, long phone);
		//view contact
		public List<Contact> fetchAllContacts(int userId);
		//add contact
		public Contact createContact(int userId,Contact contact);
		//edit contact
		public boolean updateContact(int contactId,String contactName,long contactPhone);
		//delete contact
		public boolean  deleteContact(int contactId);
		//delete profile
		public boolean deleteUser(int userId);
		
		//logout

}
