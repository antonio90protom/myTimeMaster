package com.protom.mytime.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.protom.mytime.dao.Dao;
import com.protom.mytime.dao.entity.AbstractEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.AbstractSearchFilter;
import com.protom.mytime.dao.mapper.MapperUtils;

public class AbstractDao<T> implements Dao<T> {
	
	@PersistenceContext
    protected EntityManager em;
	
	@Autowired
	protected MapperUtils mu;
	
	public List<T> getAll() throws DaoException {
		List<T> result = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			// Recupero il tipo di entity su cui fare la query a partire dal tipo generico
			@SuppressWarnings("unchecked")
			Class<T> type = ((Class<T>) ((ParameterizedType) getClass()
				      .getGenericSuperclass()).getActualTypeArguments()[0]);
			
			CriteriaQuery<T> q = cb.createQuery( type );
			Root<T> r = q.from(type);
			q.select(r);
			result = em.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DaoException("Errore nell'estrazione dei dati", e);
		}
		return result;
	}
	
	public boolean persist( T entity ) throws DaoException {
		boolean save = false;
		try {
			if( entity instanceof AbstractEntity ) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String authenticatedUser = authentication.getName();
				AbstractEntity e = (AbstractEntity) entity;
				e.setInsertDate(new Date());
				e.setInsertUser(authenticatedUser);
			}
			em.persist(entity);
			save = true;
		} catch (Exception e ) {
			throw new DaoException("Errore nell'inserimento dei dati", e);
		}
		return save;
	}
	
	public boolean merge( T entity ) throws DaoException {
		boolean update = false;
		try {
			if( entity instanceof AbstractEntity ) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String authenticatedUser = authentication.getName();
				AbstractEntity e = (AbstractEntity) entity;
				e.setUpdateDate(new Date());
				e.setUpdateUser(authenticatedUser);
			}
			em.merge(entity);
			update = true;
		} catch (Exception e) {
			throw new DaoException("Errore nell'aggiornamento dei dati", e);
		}
		return update;
	}
	
	public boolean delete( T entity ) throws DaoException {
		boolean delete = false;
		try {
			em.remove(entity);
			delete = true;
		} catch (Exception e) {
			throw new DaoException("Errore nell'eliminazione dei dati", e);
		}
		return delete;
	}
	
	protected void setPagination(TypedQuery<?> query, AbstractSearchFilter filter) {
		if( filter.getPage() != null && filter.getPageSize() != null ) {
			query.setFirstResult( filter.getPage() * filter.getPageSize() ).setMaxResults( filter.getPageSize() );
		}
	}

}
