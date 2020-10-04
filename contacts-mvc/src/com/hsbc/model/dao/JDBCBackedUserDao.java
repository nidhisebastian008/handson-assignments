package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.utilities.DBUtility;

public class JDBCBackedUserDao  implements UserDao{

	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from profile_table where profile_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("profile_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				user.setDob(resultSet.getString("dob"));
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
	public User storeUser(User user) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for profile_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				// throw some exception to the client
			} 
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into profile_table values(?,?,?,?,?)");
			preparedStatement.setInt(1, seq);
			//
			user.setUserId(seq);
			//
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.setString(5,user.getDob());
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
		List<User> list = new ArrayList<User>();
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from profile_table");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("profile_id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				user.setDob(resultSet.getString("dob"));
				list.add(user);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User updateUser(int userId, User user) {
		try
		{
			Connection connection = DBUtility.getConnection();
			String updateQuery = "update profile_table set   password = ?  , phone= ? where profile_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setLong(2, user.getPhone());
			preparedStatement.setInt(3, userId);
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

	@Override
	public List<Contact> fetchAllContacts(int userId) {
		// TODO Auto-generated method stub
		List<Contact> list = new ArrayList<Contact>();
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from contact_table where profile_id_ref=?");
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
//				User user = new User();
//				user.setUserId(resultSet.getInt("user_id"));
//				user.setName(resultSet.getString("name"));
//				user.setPassword(resultSet.getString("password"));
//				user.setPhone(resultSet.getLong("phone"));
				Contact contact= new Contact();
				contact.setUserId(resultSet.getInt("profile_id_ref"));
				contact.setContactId(resultSet.getInt("contact_id"));
				contact.setContactName(resultSet.getString("contact_name"));
				contact.setContactPhone(resultSet.getLong("contact_phone"));
				
				list.add(contact);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Contact storeContact(int userId,Contact contact) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for contact_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				// throw some exception to the client
			} 
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into contact_table values(?,?,?,?)");
			preparedStatement.setInt(1, userId);
			//
			contact.setUserId(userId);
			preparedStatement.setInt(2, seq);
			contact.setContactId(seq);
			//
			
			//
			preparedStatement.setString(3, contact.getContactName());
			preparedStatement.setLong(4, contact.getContactPhone());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public boolean updateContact(int contactId,String contactName,long contactPhone) {
		try
		{
			Connection connection = DBUtility.getConnection();
			String updateQuery = "update  contact_table set contact_name=?,contact_phone=?  where contact_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			
			preparedStatement.setString(1, contactName);
			preparedStatement.setLong(2, contactPhone);
			preparedStatement.setInt(3, contactId);
//			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
//			resultSet.close();
			preparedStatement.close();
			connection.close();
			return true;
		}
		
		 catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		
		return false;

	}

	@Override
	public boolean deleteContact(int contactId) {
		// TODO Auto-generated method stub
		try
		{
			Connection connection = DBUtility.getConnection();
			String updateQuery = "delete from contact_table  where contact_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			
			preparedStatement.setInt(1, contactId);
//			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
//			resultSet.close();
			preparedStatement.close();
			connection.close();
			return true;
		}
		
		 catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		try
		{
			Connection connection = DBUtility.getConnection();
			String updateQuery = "delete from profile_table  where profile_id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			
			preparedStatement.setInt(1, userId);
//			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
//			resultSet.close();
			preparedStatement.close();
			connection.close();
			return true;
		}
		
		 catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return false;
		
	}

}
