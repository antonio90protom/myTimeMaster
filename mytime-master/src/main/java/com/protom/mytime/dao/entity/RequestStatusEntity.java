package com.protom.mytime.dao.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "mp_request_status")
@ApiIgnore
public class RequestStatusEntity extends AbstractEntity {

	private static final long serialVersionUID = -5281018579361321058L;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_status")
	private StatusEntity state;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_request")
	private RequestEntity request;
	@Column(name = "date_start", nullable = false)
	private Date start;
	@Column(name = "date_end")
	private Date end;
	@Column(name = "note")
	private String note;
	
	public StatusEntity getState() {
		return state;
	}
	public void setState(StatusEntity state) {
		this.state = state;
	}
	public RequestEntity getRequest() {
		return request;
	}
	public void setRequest(RequestEntity request) {
		this.request = request;
	}
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

}
