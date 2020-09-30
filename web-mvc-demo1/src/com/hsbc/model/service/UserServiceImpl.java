package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
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
		
		User createdUser = userDao.store(user);
		return createdUser;
	}

	@Override
	public User updatePhone(int userId, long phone) {
		// TODO Auto-generated method stub
		User retUser=getUser(userId);
		retUser.setPhone(phone);
		User updatedUser=userDao.updateUser(userId, retUser);
		return updatedUser;
	}

	@Override
	public User updatePassword(int userId, String password) {
		// TODO Auto-generated method stub
		User retUser=getUser(userId);
		retUser.setPassword(password);
		User updatedUser=userDao.updateUser(userId, retUser);
		return updatedUser;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		List<User> usersList=fetchAllUsers();
		for(User user:usersList)
		{
			if(user.getUserId()==userId)
			{
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		return userDao.fetchAllUsers();
		
	}

}
