package com.hsbc.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.utilities.DBUtility;
import com.hsbc.model.utilities.UserFactory;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = null;
	
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance("dao");
	}

	@Override
	public User login(int userId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = userDao.authenticate(userId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went wrong");
		}
		return user;
		
		
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.storeUser(user);
	}

	@Override
	public List<User> fetchAllUsers() {
		return userDao.fetchAllUsers();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		List<User> usersList= fetchAllUsers();
		for(User user:usersList)
		{
			if(userId==user.getUserId())return user;
		}
		return null;
	}

	@Override
	public User updatePassword(int userId, String password) {
		User retUser= getUser(userId);
		retUser.setPassword(password);
		
		User updatedUser=userDao.updateUser(userId, retUser);
		return updatedUser;
	}

	@Override
	public User updatePhone(int userId, long phone) {
		// TODO Auto-generated method stub
		User retUser= getUser(userId);
		retUser.setPhone(phone);;
		
		User updatedUser=userDao.updateUser(userId, retUser);
		return updatedUser;
	}

	@Override
	public List<Contact> fetchAllContacts(int userId) {
		return userDao.fetchAllContacts(userId);
			}

	@Override
	public Contact createContact(int userId, Contact contact) {
		// TODO Auto-generated method stub
		
		return userDao.storeContact(userId,contact);
	}

	@Override
	public boolean updateContact(int contactId, String contactName, long contactPhone) {
		// TODO Auto-generated method stub
		return  userDao.updateContact(contactId, contactName, contactPhone);
		
	}

	@Override
	public boolean deleteContact(int contactId) {
		// TODO Auto-generated method stub
		return userDao.deleteContact(contactId);
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

}
