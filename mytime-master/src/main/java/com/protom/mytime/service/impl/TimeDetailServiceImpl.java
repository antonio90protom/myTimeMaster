package com.protom.mytime.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protom.mytime.dao.TimeDetailDao;
import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;
import com.protom.mytime.service.TimeDetailService;
import com.protom.mytime.service.exception.ServiceException;

@Service
public class TimeDetailServiceImpl implements TimeDetailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimeDetailServiceImpl.class);
	
	@Autowired
	private TimeDetailDao dao;

	@Override
	public List<TimeDetailDto> find(TimeDetailSearchFilter filter) throws ServiceException {
		List<TimeDetailDto> result = null;
		try {
			result = dao.findByFilter(filter);
		} catch (Exception e) {
			LOG.error("Errore nella ricerca dei dettagli del timesheet", e);
			throw new ServiceException();
		}
		return result;
	}

	@Override
	public Long count(TimeDetailSearchFilter filter) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeDetailDto> save(List<TimeDetailDto> timeDetail) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeDetailDto> update(List<TimeDetailDto> timeDetail) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
