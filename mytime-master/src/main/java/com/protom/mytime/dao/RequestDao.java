package com.protom.mytime.dao;

import java.util.List;

import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.RequestSearchFilter;
import com.protom.mytime.dto.RequestDto;

public interface RequestDao {
	
	List<RequestDto> findByFilter( RequestSearchFilter filter ) throws DaoException;

}
