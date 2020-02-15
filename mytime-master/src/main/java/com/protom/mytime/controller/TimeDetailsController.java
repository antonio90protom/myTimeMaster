package com.protom.mytime.controller;

import java.time.LocalDate;
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
import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;
import com.protom.mytime.service.TimeDetailService;

@RestController
@RequestMapping("/api/timesheet/details")
public class TimeDetailsController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TimeDetailsController.class);
	
	@Autowired
	private TimeDetailService service;
	
	@GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<List<TimeDetailDto>>> get(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "jobCode", required = false) String jobCode,
			@RequestParam(name = "taskCode", required = false) String taskCode,
			@RequestParam(name = "day", required = false) LocalDate day,
			@RequestParam(name = "startTime", required = false) String startTime,
			@RequestParam(name = "endTime", required = false) String endTime,
			@RequestParam(name = "location", required = false) String location,
			@RequestParam(name = "detailGroup", required = false) Integer detailGroup,
			@RequestParam(name = "timesheetId", required = false) Integer timesheetId,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "pageSize", required = false) Integer pageSize
			) {
		Response<List<TimeDetailDto>> data = new Response<>();
		ResponseEntity<Response<List<TimeDetailDto>>> response = null;
		try {
			TimeDetailSearchFilter filter = TimeDetailSearchFilter.builder()
					.setDay(day)
					.setDetailGroup(detailGroup)
					.setId(id)
					.setIdTime(timesheetId)
					.setJobCode(jobCode)
					.setLocation(location)
					.setTaskCode(taskCode);
			
			filter.setPage(page);
			filter.setPageSize(pageSize);
			
			List<TimeDetailDto> details = service.find(filter);
			data
			.setPayload(details)
			.setTotal(service.count(filter))
			.setRecords(details.size())
			.setStatus(ControllerStatus.OK)
			.setStatusMessage("OK");
			// Valorizzo la response
			response = new ResponseEntity<>(data, HttpStatus.OK);
		} catch ( Exception e ) {
			LOG.error("Errore nel recupero dei dettagli timesheet", e);
			data
			.setStatusMessage("Errore nel recupero dei dettagli del timesheet", e)
			.setStatus(ControllerStatus.KO);
			response = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<List<TimeDetailDto>>> post(@RequestBody List<TimeDetailDto> detail) {
		return null;
	}
	
	@PutMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<List<TimeDetailDto>>> put(@RequestBody List<TimeDetailDto> detail) {
		return null;
	}
	
	@DeleteMapping
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Response<TimeDetailDto>> delete(@RequestParam(name = "id", required = true) Integer id) {
		return null;
	}

}
