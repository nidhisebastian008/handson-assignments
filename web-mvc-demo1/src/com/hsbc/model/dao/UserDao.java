package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;

public interface UserDao {
	public User authenticate(int userId, String password) throws AuthenticationException;
	public User store(User user);
	public List<User> fetchAllUsers();
	public User updateUser(int userId, User user);
}
