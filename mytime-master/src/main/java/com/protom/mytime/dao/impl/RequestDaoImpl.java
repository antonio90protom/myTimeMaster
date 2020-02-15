package com.protom.mytime.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.protom.mytime.dao.RequestDao;
import com.protom.mytime.dao.entity.RequestEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.RequestSearchFilter;
import com.protom.mytime.dto.RequestDto;

@Repository
public class RequestDaoImpl extends AbstractDao<RequestEntity> implements RequestDao {

	@Override
	public List<RequestDto> findByFilter(RequestSearchFilter filter) throws DaoException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<RequestDto> q = cb.createQuery(RequestDto.class);
		Root<RequestEntity> r = q.from( RequestEntity.class );
		q.select(cb.construct(
				RequestDto.class,
				r.get("")
				));
		setFilter( filter, cb, q, r );
		TypedQuery<RequestDto> query = em.createQuery(q);
		if( filter.getPage() != null && filter.getPageSize() != null ) {
			query.setFirstResult( filter.getPage() * filter.getPageSize() ).setMaxResults( filter.getPageSize() );
		}
		return query.getResultList();
	}
	
	private void setFilter(RequestSearchFilter filter, CriteriaBuilder cb, CriteriaQuery<RequestDto> q, Root<RequestEntity> r) {
		if( filter != null ) {
			if( filter.getId() != null ) {
				q.where(cb.equal(r.get("id"), filter.getId()));
			} else {
				List<Predicate> restrictions = new ArrayList<>();
				if( filter.getAuto() != null ) {
					restrictions.add(
							cb.equal(r.get("richiestaAuto"), filter.getAuto())
							);
				}
				if( filter.getTaxi() != null ) {
					restrictions.add(
							cb.equal(r.get("richiestaTaxi"), filter.getTaxi())
							);
				}
			}
		}
	}

}
