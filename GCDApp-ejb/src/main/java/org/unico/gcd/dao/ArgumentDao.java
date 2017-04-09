package org.unico.gcd.dao;

import java.util.Collection;
import java.util.List;

import org.unico.gcd.dao.exception.DaoException;
import org.unico.gcd.domain.Arguments;

/**
 * @author Rohan Dave
 * 
 * Will add both the integers to DB.
 * 
 * @Argument i
 * @Argument j
 * @throws DaoException
 */

public interface ArgumentDao {
	

	/**
	 * Will get the argument list from DB.
	 * 
	 */
	public Collection<Arguments> getArgumentList();

	public void saveArguments(Integer i, Integer j) throws DaoException;

}
