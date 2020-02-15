package com.protom.mytime.dao;

import java.util.List; 
import com.protom.mytime.dao.exception.DaoException;

public interface Dao<T> {

	List<T> getAll() throws DaoException;
	boolean persist( T entity ) throws DaoException;
	boolean merge( T entity ) throws DaoException;
	boolean delete( T entity ) throws DaoException;
	
}
