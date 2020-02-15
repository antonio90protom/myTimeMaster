package com.protom.mytime.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "mp_time_detail")
@ApiIgnore
public class TimeDetailEntity extends AbstractEntity {

	private static final long serialVersionUID = -4257051573400490766L;	
	
	@Column(name = "job_code", nullable = false)
	private String jobCode;
	@Column(name = "task_code")
	private String taskCode;
	@Column(name = "day")
	private Date day;
	@Column(name = "start_time", nullable = false)
	private String startTime;
	@Column(name = "end_time", nullable = false)
	private String endTime;
	@Column(name = "location")
	private String location;
	@Column(name = "detail_group")
	private Integer detailGroup;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_time")
	private TimeEntity timesheet;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "timeDetail")
	private RequestEntity request;
	
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
	public TimeEntity getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimeEntity timesheet) {
		this.timesheet = timesheet;
	}
	public RequestEntity getRequest() {
		return request;
	}
	public void setRequest(RequestEntity request) {
		this.request = request;
	}

}
