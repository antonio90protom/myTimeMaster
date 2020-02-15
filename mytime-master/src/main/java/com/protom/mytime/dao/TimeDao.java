package com.protom.mytime.dao;

import java.util.List;

import com.protom.mytime.dao.entity.TimeEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;

public interface TimeDao extends Dao<TimeEntity> {
	
	List<TimeDto> findByFilter(TimeSearchFilter filter) throws DaoException;
	Long countByFilter(TimeSearchFilter filter) throws DaoException;
	TimeDto persist(TimeDto ts) throws DaoException;
	TimeDto update(TimeDto ts) throws DaoException;
	boolean delete(TimeDto ts) throws DaoException;

}
