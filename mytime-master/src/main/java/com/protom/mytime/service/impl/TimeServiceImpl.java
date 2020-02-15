package com.protom.mytime.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protom.mytime.dao.TimeDao;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;
import com.protom.mytime.service.TimeService;
import com.protom.mytime.service.UserService;
import com.protom.mytime.service.exception.ServiceException;
import com.protom.mytime.utils.Tools;

@Service
public class TimeServiceImpl implements TimeService {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimeServiceImpl.class);
	
	@Autowired
	private TimeDao dao;
	
	@Autowired
	private UserService userService;
	
	private void checkFilter(TimeSearchFilter filter) {
		String loggedUsername = userService.loggedUsername();
		// Verifico se sono stati richiesti i timesheet dei dipendenti da un approvatore
		if( Tools.getValue( filter.getApprovation() ) ) {
			filter.setApproverUsername(loggedUsername);
		} else {
			// Verfico se è stato passato uno username in input ed eventualmente se è lo stesso dell'utente loggato
			if( filter.getOwnerUsername() != null && !filter.getOwnerUsername().equals(loggedUsername) ) {
				LOG.warn("ATTENZIONE! L'utente <" + loggedUsername + "> ha tentato di recuperare i timesheet dell'utente <" + filter.getOwnerUsername() + ">");
			}
			// Forse è un furbetto della rete. Imposto l'owner con il nome utente loggato così da impedire il recupero di informazioni altrui
			filter.setOwnerUsername(loggedUsername);
		}
	}

	@Override
	public List<TimeDto> find(TimeSearchFilter filter) throws ServiceException {
		List<TimeDto> result = null;
		try {
			checkFilter( filter );
			result = dao.findByFilter(filter);
		} catch (DaoException e) {
			LOG.error("Errore nella ricerca dei timesheet con il seguente input <" + filter + ">", e);
			throw new ServiceException();
		}
		return result;
	}

	@Override
	public Long count(TimeSearchFilter filter) throws ServiceException {
		Long records = null;
		try {
			checkFilter( filter );
			records = dao.countByFilter(filter);
		} catch ( DaoException e ) {
			LOG.error("Errore nella count dei timesheet con il seguente input <" + filter + ">", e);
			throw new ServiceException();
		}
		return records;
	}

	@Override
	@Transactional
	public TimeDto save(TimeDto timesheet) throws ServiceException {
		TimeDto ts = null;
		try {
			ts = dao.persist(timesheet);
		} catch ( DaoException e ) {
			LOG.error("Errore nel salvataggio del timesheet <" + timesheet + ">", e);
			throw new ServiceException();
		}
		return ts;
	}

	@Override
	@Transactional
	public TimeDto update(TimeDto timesheet) throws ServiceException {
		TimeDto ts = null;
		try {
			ts = dao.persist(timesheet);
		} catch ( DaoException e ) {
			LOG.error("Errore nel salvataggio del timesheet <" + timesheet + ">", e);
			throw new ServiceException();
		}
		return ts;
	}

	@Override
	public boolean delete(Integer id) throws ServiceException {
		boolean removed = false;
		try {
			TimeDto ts = new TimeDto();
			ts.setId(id);
			removed = dao.delete(ts);
		} catch (Exception e) {
			removed = false;
			LOG.error("Errore nell'eliminazione del timesheet con id <" + id + ">", e);
			throw new ServiceException();
		}
		return removed;
	}

}
