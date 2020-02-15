package com.protom.mytime.controller;

import java.util.List; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
import com.protom.mytime.controller.bean.Response;
import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;
import com.protom.mytime.service.TimeService;


@RestController
@RequestMapping("/api/timesheet")
public class TimeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimeController.class);
	
	@Autowired
	private TimeService service;
	
	@GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<List<TimeDto>>> get(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "owner", required = false) String ownerUsername,
			@RequestParam(name = "approvation", required = false) Boolean approvation,
			@RequestParam(name = "year", required = false) Integer year,
			@RequestParam(name = "month", required = false) Integer month,
			@RequestParam(name = "period", required = false) Integer period,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "pageSize", required = false) Integer pageSize
			) {
		Response<List<TimeDto>> data = new Response<>();
		ResponseEntity<Response<List<TimeDto>>> response = null;
		try {
			// Inizializzo il filtro per la ricerca
			TimeSearchFilter filter = TimeSearchFilter.builder()
					.setId(id)
					.setOwnerUsername(ownerUsername)
					.setYear(year)
					.setMonth(month)
					.setPeriod(period)
					.setApprovation(approvation);
			// Inizializzo le variabili utilizzate per la paginazione
			filter.setPage(page);
			filter.setPageSize(pageSize);
			List<TimeDto> payload = service.find(filter);
			data.setPayload(payload)
			.setRecords(payload.size())
			.setStatus(ControllerStatus.OK)
			.setStatusMessage("OK")
			.setTotal(service.count(filter));
			// Costruisco la response
			response = new ResponseEntity<>(data, HttpStatus.OK);
		} catch ( Exception e ) {
			data
			.setStatusMessage("Errore nel recupero del timesheet", e)
			.setStatus(ControllerStatus.KO);
			response = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Errore nel recupero del timesheet", e);
		}
		return response; 
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<TimeDto>> post( @RequestBody() TimeDto timesheet ) {
		Response<TimeDto> data = new Response<>();
		ResponseEntity<Response<TimeDto>> response = null;
		try {
			timesheet = service.save(timesheet);
			data.setPayload(timesheet);
			data.setStatusMessage("OK");
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		} catch ( Exception e ) {
			data.setStatusMessage("Errore nell'inserimento del timesheet.", e);
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<TimeDto>> put( @RequestBody() TimeDto timesheet ) {
		Response<TimeDto> data = new Response<>();
		ResponseEntity<Response<TimeDto>> response = null;
		try {
			timesheet = service.save(timesheet);
			data.setPayload(timesheet);
			data.setStatusMessage("OK");
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		} catch ( Exception e ) {
			data.setStatusMessage("Errore nell'aggiornamento del timesheet.", e);
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<TimeDto>> delete(
			@RequestParam(name = "id", required = true) Integer id 
			) {
		Response<TimeDto> data = new Response<>();
		ResponseEntity<Response<TimeDto>> response = null;
		try {
			data.setStatusMessage("OK");
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		} catch ( Exception e ) {
			data.setStatusMessage("Errore nell'eliminazione del timesheet.", e);
			response = new ResponseEntity<Response<TimeDto>>(data, HttpStatus.OK);
		}
		return response;
	}

}
