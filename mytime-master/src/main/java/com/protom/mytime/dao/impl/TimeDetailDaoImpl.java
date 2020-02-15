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

import com.protom.mytime.dao.TimeDetailDao;
import com.protom.mytime.dao.entity.TimeDetailEntity;
import com.protom.mytime.dao.entity.TimeEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;

@Repository
public class TimeDetailDaoImpl extends AbstractDao<TimeDetailEntity> implements TimeDetailDao {

	@Override
	public List<TimeDetailDto> findByFilter(TimeDetailSearchFilter filter) throws DaoException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TimeDetailDto> q = cb.createQuery(TimeDetailDto.class);
		Root<TimeDetailEntity> r = q.from( TimeDetailEntity.class );
	
		Predicate[] predicates = setFilter(filter, cb, r);
		if( predicates != null ) {
			q.where( predicates );
		}
		q.select(
				cb.construct(
						TimeDetailDto.class, 
						r.get("id"), 
						r.get("jobCode"),
						r.get("taskCode"),
						r.get("day"),
						r.get("startTime"),
						r.get("endTime"),
						r.get("location"),
						r.get("detailGroup"))
				);
		TypedQuery<TimeDetailDto> query = em.createQuery(q);
		setPagination(query, filter);
		return query.getResultList();
	}
	
	public TimeDetailDto persist( TimeDetailDto ts ) throws DaoException {
		TimeDetailEntity details = mu.map(ts, TimeDetailEntity.class);
		super.persist(details);
		return mu.map(details, TimeDetailDto.class);
	}
	
	private Predicate[] setFilter(TimeDetailSearchFilter filter, CriteriaBuilder cb, Root<TimeDetailEntity> r) {
		List<Predicate> restrictions = new ArrayList<>();
		if( filter != null ) {
			Join<TimeDetailEntity, TimeEntity> timesheet = r.join("timesheet", JoinType.INNER);
			if( filter.getId() != null ) {
				restrictions.add(cb.equal(r.get("id"), filter.getId()));
			}
			if( filter.getDay() != null ) {
				restrictions.add(cb.equal(r.get("day"), filter.getDay()));
			}
			if( filter.getIdTime() != null ) {
				restrictions.add(cb.equal(timesheet.get("id"), filter.getIdTime()));
			}
			if( filter.getOwnerUsername() != null ) {
				restrictions.add(cb.equal(timesheet.get("ownerUser"), filter.getOwnerUsername()));
			}
			if( filter.getJobCode() != null ) {
				restrictions.add(cb.equal(r.get("jobCode"), filter.getJobCode()));
			}
			if( filter.getLocation() != null ) {
				restrictions.add(cb.equal(r.get("location"), filter.getLocation()));
			}
			if( filter.getTaskCode() != null ) {
				restrictions.add(cb.equal(r.get("taskCode"), filter.getTaskCode()));
			}
		}
		Predicate[] arrayRestriction = null ;
		if( !restrictions.isEmpty() ) {
			arrayRestriction = new Predicate[restrictions.size()];
			restrictions.toArray(arrayRestriction);
		}
		return arrayRestriction;
	}

}
