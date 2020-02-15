package com.protom.mytime.dto;

public class RequestDto {
	
	private Integer id;
	private String note;
	private Boolean richiestaAuto;
	private Boolean richiestaTaxi;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
