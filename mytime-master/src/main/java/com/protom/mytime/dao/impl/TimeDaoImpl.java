package com.protom.mytime.dao.impl;

import java.util.ArrayList;
import java.util.List; 
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root; 
import org.springframework.stereotype.Repository; 
import com.protom.mytime.dao.TimeDao;
import com.protom.mytime.dao.entity.StatusEntity;
import com.protom.mytime.dao.entity.TimeEntity;
import com.protom.mytime.dao.entity.TimeStatusEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;

@Repository
public class TimeDaoImpl extends AbstractDao<TimeEntity> implements TimeDao {
	
	public TimeDto persist( TimeDto ts ) throws DaoException {
		TimeEntity timesheet = mu.map(ts, TimeEntity.class);
		super.persist(timesheet);
		return mu.map(timesheet, TimeDto.class);
	}

	@Override
	public List<TimeDto> findByFilter(TimeSearchFilter filter) throws DaoException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TimeDto> q = cb.createQuery(TimeDto.class);
		Root<TimeEntity> r = q.from( TimeEntity.class );
		Predicate[] predicates = setFilter( filter, cb, r );
		if( predicates != null ) {
			q.where( predicates );
		}
		q.select(
				cb.construct(
						TimeDto.class, 
						r.get("id"), 
						r.get("ownerUser"),
						r.get("approverUser"),
						r.get("year"),
						r.get("month"),
						r.get("period"))
				);
		TypedQuery<TimeDto> query = em.createQuery(q);
		setPagination(query, filter);
		return query.getResultList();
	}
	
	@Override
	public Long countByFilter(TimeSearchFilter filter) throws DaoException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<TimeEntity> r = q.from( TimeEntity.class );
		Predicate[] predicates = setFilter( filter, cb, r );
		if( predicates != null ) {
			q.where( predicates );
		}
		q.select(cb.count(r));
		TypedQuery<Long> query = em.createQuery(q);
		return query.getSingleResult();
	}
	
	private Predicate[] setFilter(TimeSearchFilter filter, CriteriaBuilder cb, Root<TimeEntity> r) {
		List<Predicate> restrictions = new ArrayList<>();
		if( filter != null ) {
			if( filter.getId() != null ) {
				restrictions.add( cb.equal(r.get("id"), filter.getId()) );
			}
			if( filter.getApproverUsername() != null ) {
				restrictions.add(
						cb.equal(r.get("approverUser"), filter.getApproverUsername())
						);
			}
			if( filter.getMonth() != null ) {
				restrictions.add(
						cb.equal(r.get("month"), filter.getMonth())
						);
			}
			if( filter.getOwnerUsername() != null ) {
				restrictions.add(
						cb.equal(r.get("ownerUser"), filter.getOwnerUsername())
						);
			}
			if( filter.getPeriod() != null ) {
				restrictions.add(
						cb.equal(r.get("period"), filter.getPeriod())
						);
			}
			if( filter.getYear() != null ) {
				restrictions.add(
						cb.equal(r.get("year"), filter.getYear())
						);
			}
			if( filter.getIdStatus() != null ) {
				Join<TimeEntity, TimeStatusEntity> status = r.join("states", JoinType.INNER);
				Join<TimeStatusEntity, StatusEntity> stDesc = status.join("state", JoinType.INNER);
				restrictions.add(cb.equal(stDesc.get("id"), filter.getIdStatus()));
				restrictions.add(cb.isNull(status.get("end")));
			}
		}
		Predicate[] arrayRestriction = null ;
		if( !restrictions.isEmpty() ) {
			arrayRestriction = new Predicate[restrictions.size()];
			restrictions.toArray(arrayRestriction);
		}
		return arrayRestriction;
	}

	@Override
	public TimeDto update(TimeDto ts) throws DaoException {
		TimeEntity timesheet = mu.map(ts, TimeEntity.class);
		super.merge( timesheet );
		return mu.map(timesheet, TimeDto.class);
	}

	@Override
	public boolean delete(TimeDto ts) throws DaoException {
		return super.delete( mu.map(ts, TimeEntity.class) );
	}

}
