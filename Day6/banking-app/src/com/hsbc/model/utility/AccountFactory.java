package com.hsbc.model.utility;

import com.hsbc.model.dao.ArrayBackedAccountDao;
import com.hsbc.model.service.AccountServiceImpl;

public class AccountFactory {
	
	
	
	public static Object getInstance(Type type) {
		Object obj = null;
		switch(type) {
		case DAO : 
			obj = new ArrayBackedAccountDao();
			break;
		case SERVICE :
			obj = new AccountServiceImpl();
			break;
		}
		return obj;
	}

}
