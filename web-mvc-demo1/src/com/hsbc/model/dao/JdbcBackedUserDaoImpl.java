package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.utilities.DBUtility;

public class JdbcBackedUserDaoImpl implements UserDao {

	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from user_table where user_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if(user == null) {
				throw new AuthenticationException("Sorry Username or Password is Incorrect");
			} 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				// throw some exception to the client
			} 
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into user_table values(?,?,?,?)");
			preparedStatement.setInt(1, seq);
			//
			user.setUserId(seq);
			//
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<User> usersList= new ArrayList<>();
		
		try {
			Connection connection = DBUtility.getConnection();
			String selectQuery = "select * from user_table ";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				usersList.add(user);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close(); 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return usersList;
		
		
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		try
		{
			Connection connection = DBUtility.getConnection();
			String updateQuery = "update user_table set  name=? , password = ?  , phone= ? where user_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setLong(3, user.getPhone());
			preparedStatement.setInt(4, userId);
//			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
//			resultSet.close();
			preparedStatement.close();
			connection.close();
		}
		
		 catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		
		return user;
	}

}
