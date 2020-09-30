package com.hsbc.model.utilities;

import com.hsbc.model.dao.JdbcBackedUserDaoImpl;
import com.hsbc.model.service.UserServiceImpl;

public class UserFactory {

	public static Object getInstance(String type) {
		if(type.equals("dao")) {
			return new JdbcBackedUserDaoImpl();
		}
		if(type.equals("service")) {
			return new UserServiceImpl();
		}
		return null;
	}
}
