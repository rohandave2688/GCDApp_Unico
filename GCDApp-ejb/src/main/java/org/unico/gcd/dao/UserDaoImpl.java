package org.unico.gcd.dao;


import java.security.GeneralSecurityException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.unico.gcd.domain.User;


public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName = "unico.persistenceContext")
	EntityManager em;
	
	@Override
	public User getUser(String username, String password) {
	 
		 List<User> users = (List<User>)em.createNativeQuery
				 ("SELECT * FROM USER where userName = '" + username + "' and password = md5('" + password + "')",
				 User.class).getResultList(); 
		 if(users.size() > 0) {
			 return users.get(0);
		 }
		 return null;
	}

}
