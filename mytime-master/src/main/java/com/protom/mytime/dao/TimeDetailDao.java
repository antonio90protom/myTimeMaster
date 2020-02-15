package com.protom.mytime.dao;

import java.util.List;

import com.protom.mytime.dao.entity.TimeDetailEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;

public interface TimeDetailDao extends Dao<TimeDetailEntity> {
	
	List<TimeDetailDto> findByFilter(TimeDetailSearchFilter filter) throws DaoException;

}
