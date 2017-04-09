package org.unico.gcd.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.unico.gcd.dao.exception.DaoException;
import org.unico.gcd.domain.Arguments;


/**
 * @author Rohan Dave
 * 
 */

@Stateless
public class ArgumentDaoImpl implements ArgumentDao {

	@PersistenceContext(unitName = "unico.persistenceContext")
	EntityManager em;
	

	@Override
	public Collection<Arguments> getArgumentList() {
		 Query query = em.createQuery("SELECT p FROM Params p");
		 return (Collection<Arguments>) query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveArguments(Integer param1, Integer param2) throws DaoException {
		Arguments args = new Arguments();
		args.setArgument1(param1);
		args.setArgument2(param2);
		
		try {
			em.persist(args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		} 
	}


}
