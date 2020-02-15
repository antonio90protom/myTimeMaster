package com.protom.mytime.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name = "mp_request")
@ApiIgnore
public class RequestEntity extends AbstractEntity {

	private static final long serialVersionUID = -803434719374105894L;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mp_time_detail")
	private TimeDetailEntity timeDetail;
	@Column(name = "note")
	private String note;
	@Column(name = "flg_auto")
	private Boolean richiestaAuto;
	@Column(name = "flg_taxi")
	private Boolean richiestaTaxi;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "request")
	private List<RequestStatusEntity> states;

	public TimeDetailEntity getTimeDetail() {
		return timeDetail;
	}
	public void setTimeDetail(TimeDetailEntity timeDetail) {
		this.timeDetail = timeDetail;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Boolean getRichiestaAuto() {
		return richiestaAuto;
	}
	public void setRichiestaAuto(Boolean richiestaAuto) {
		this.richiestaAuto = richiestaAuto;
	}
	public Boolean getRichiestaTaxi() {
		return richiestaTaxi;
	}
	public void setRichiestaTaxi(Boolean richiestaTaxi) {
		this.richiestaTaxi = richiestaTaxi;
	}

}
