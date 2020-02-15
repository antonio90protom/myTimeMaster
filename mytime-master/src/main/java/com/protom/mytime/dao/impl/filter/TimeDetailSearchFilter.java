package com.protom.mytime.dao.impl.filter;

import java.time.LocalDate;

public class TimeDetailSearchFilter extends AbstractSearchFilter {

	private static final long serialVersionUID = 4486768308868942794L;

	private Integer id;
	private Integer idTime;
	private String jobCode;
	private String taskCode;
	private String location;
	private Integer detailGroup;
	private LocalDate day;
	private String ownerUsername;
	
	public static TimeDetailSearchFilter builder() {
		return new TimeDetailSearchFilter();
	}
	
	public Integer getId() {
		return id;
	}
	public TimeDetailSearchFilter setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getIdTime() {
		return idTime;
	}
	public TimeDetailSearchFilter setIdTime(Integer idTime) {
		this.idTime = idTime;
		return this;
	}
	public String getJobCode() {
		return jobCode;
	}
	public TimeDetailSearchFilter setJobCode(String jobCode) {
		this.jobCode = jobCode;
		return this;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public TimeDetailSearchFilter setTaskCode(String taskCode) {
		this.taskCode = taskCode;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public TimeDetailSearchFilter setLocation(String location) {
		this.location = location;
		return this;
	}
	public Integer getDetailGroup() {
		return detailGroup;
	}
	public TimeDetailSearchFilter setDetailGroup(Integer detailGroup) {
		this.detailGroup = detailGroup;
		return this;
	}
	public LocalDate getDay() {
		return day;
	}
	public TimeDetailSearchFilter setDay(LocalDate day) {
		this.day = day;
		return this;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public TimeDetailSearchFilter setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
		return this;
	}
}
