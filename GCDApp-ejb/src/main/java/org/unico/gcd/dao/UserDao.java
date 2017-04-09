package org.unico.gcd.dao;

import java.security.GeneralSecurityException;

import org.unico.gcd.domain.User;

public interface UserDao {
	
	public User getUser(String userName, String password);
}
