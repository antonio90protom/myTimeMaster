package com.protom.mytime.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "mp_time")
@ApiIgnore
public class TimeEntity extends AbstractEntity {

	private static final long serialVersionUID = 1386483070278466656L;

	@Column(name = "owner_user_name", nullable = false)
	private String ownerUser;
	@Column(name = "approver_user_name", nullable = false)
	private String approverUser;
	@Column(name = "year", nullable = false)
	private Integer year;
	@Column(name = "month", nullable = false)
	private Integer month;
	@Column(name = "period", nullable = false)
	private Integer period;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_mp_time")
	private List<TimeDetailEntity> details;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "timesheet")
	private List<TimeStatusEntity> states;
	
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
	public List<TimeDetailEntity> getDetails() {
		return details;
	}
	public void setDetails(List<TimeDetailEntity> details) {
		this.details = details;
	}
	public List<TimeStatusEntity> getStates() {
		return states;
	}
	public void setStates(List<TimeStatusEntity> states) {
		this.states = states;
	}
	
}
