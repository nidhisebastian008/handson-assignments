package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;

public interface UserService {
	
	public User login(int userId, String password) throws AuthenticationException;
	public User createUser(User user);
	public User updatePhone(int userId, long phone);
	public User updatePassword(int userId, String password);
	public User getUser(int userId);
	public List<User> fetchAllUsers();

}
