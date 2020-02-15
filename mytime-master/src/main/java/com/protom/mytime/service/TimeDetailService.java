package com.protom.mytime.service;

import java.util.List;

import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;
import com.protom.mytime.service.exception.ServiceException;

public interface TimeDetailService {
	
	public List<TimeDetailDto> find(TimeDetailSearchFilter filter) throws ServiceException;
	public Long count(TimeDetailSearchFilter filter) throws ServiceException;
	public List<TimeDetailDto> save(List<TimeDetailDto> timeDetail) throws ServiceException;
	public List<TimeDetailDto> update(List<TimeDetailDto> timeDetail) throws ServiceException;
	public boolean delete(Integer id) throws ServiceException;

}
