package com.protom.mytime.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.protom.mytime.dao.StatusDao;
import com.protom.mytime.dao.entity.StatusEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dto.StatusDto;

@Repository
public class StatusDaoImpl extends AbstractDao<StatusEntity> implements StatusDao {

	
	public List<StatusDto> getAllActive() throws DaoException {
		List<StatusDto> result = null;
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<StatusEntity> q = cb.createQuery( StatusEntity.class );
			Root<StatusEntity> r = q.from( StatusEntity.class );
			q.select(r).where(cb.equal(r.get("active"), true));
			result = mu.mapAll(em.createQuery(q).getResultList(), StatusDto.class);
		} catch (Exception e) {
			throw new DaoException("Errore nel recupero degli stati attivi", e);
		}
		return result;
	}
	
}
