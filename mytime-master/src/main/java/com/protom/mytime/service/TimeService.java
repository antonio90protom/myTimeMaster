package com.protom.mytime.service;

import java.util.List;

import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;
import com.protom.mytime.service.exception.ServiceException;

public interface TimeService {
	
	public List<TimeDto> find(TimeSearchFilter filter) throws ServiceException;
	public Long count(TimeSearchFilter filter) throws ServiceException;
	public TimeDto save(TimeDto timesheet) throws ServiceException;
	public TimeDto update(TimeDto timesheet) throws ServiceException;
	public boolean delete(Integer id) throws ServiceException;

}
