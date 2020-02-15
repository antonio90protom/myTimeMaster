package com.protom.mytime.dto;

import java.io.Serializable;
import java.util.List;

public class TimeDto implements Serializable {

	private static final long serialVersionUID = 2941576444951099049L;
	
	private Integer id;
	private String ownerUser;
	private String approverUser;
	private Integer year;
	private Integer month;
	private Integer period;
	private List<TimeDetailDto> details;
	private List<TimeStatusDto> states;
	
	public TimeDto() {}
	
	public TimeDto(Integer id, String ownerUser, String approverUser, Integer year, Integer month, Integer period) {
		super();
		this.id = id;
		this.ownerUser = ownerUser;
		this.approverUser = approverUser;
		this.year = year;
		this.month = month;
		this.period = period;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(String ownerUser) {
		this.ownerUser = ownerUser;
	}
	public String getApproverUser() {
		return approverUser;
	}
	public void setApproverUser(String approverUser) {
		this.approverUser = approverUser;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public List<TimeDetailDto> getDetails() {
		return details;
	}
	public void setDetails(List<TimeDetailDto> details) {
		this.details = details;
	}
	public List<TimeStatusDto> getStates() {
		return states;
	}
	public void setStates(List<TimeStatusDto> states) {
		this.states = states;
	}
}
