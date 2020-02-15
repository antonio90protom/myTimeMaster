package com.protom.mytime.dto;

import java.util.Date;

public class TimeStatusDto {

	private Date start;
	private Date end;
	private String note;
	private StatusDto state;
	private TimeDto timesheet;
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public StatusDto getState() {
		return state;
	}
	public void setState(StatusDto state) {
		this.state = state;
	}
	public TimeDto getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimeDto timesheet) {
		this.timesheet = timesheet;
	}
	
}
