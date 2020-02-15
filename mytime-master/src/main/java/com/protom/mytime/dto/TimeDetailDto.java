package com.protom.mytime.dto;

import java.util.Date;

public class TimeDetailDto {
	
	private Integer id;
	private String jobCode;
	private String taskCode;
	private Date day;
	private String startTime;
	private String endTime;
	private String location;
	private Integer detailGroup;
	private TimeDto timesheet;
	private RequestDto request;
	
	public TimeDetailDto() {}
	
	public TimeDetailDto(Integer id, String jobCode, String taskCode, Date day, String startTime, String endTime,
			String location, Integer detailGroup) {
		super();
		this.id = id;
		this.jobCode = jobCode;
		this.taskCode = taskCode;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.detailGroup = detailGroup;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getDetailGroup() {
		return detailGroup;
	}
	public void setDetailGroup(Integer detailGroup) {
		this.detailGroup = detailGroup;
	}
	public TimeDto getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimeDto timesheet) {
		this.timesheet = timesheet;
	}
	public RequestDto getRequest() {
		return request;
	}
	public void setRequest(RequestDto request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "TimeDetailDto [id=" + id + ", jobCode=" + jobCode + ", taskCode=" + taskCode + ", day=" + day
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location + ", detailGroup="
				+ detailGroup + ", timesheet=" + timesheet + ", request=" + request + "]";
	}

}
