package com.protom.mytime.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mp_time_status")
public class TimeStatusEntity extends AbstractEntity {

	private static final long serialVersionUID = -4169726967675664994L;
	
	@Column(name = "date_start", nullable = false)
	private Date start;
	@Column(name = "date_end")
	private Date end;
	@Column(name = "note")
	private String note;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_status")
	private StatusEntity state;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_time")
	private TimeEntity timesheet;

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
	public StatusEntity getState() {
		return state;
	}
	public void setState(StatusEntity state) {
		this.state = state;
	}
	public TimeEntity getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(TimeEntity timesheet) {
		this.timesheet = timesheet;
	}

}
