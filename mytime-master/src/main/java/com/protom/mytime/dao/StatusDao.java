package com.protom.mytime.dao;

import java.util.List;

import com.protom.mytime.dao.entity.StatusEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dto.StatusDto;

public interface StatusDao extends Dao<StatusEntity> {
	
	List<StatusDto> getAllActive() throws DaoException;

}
