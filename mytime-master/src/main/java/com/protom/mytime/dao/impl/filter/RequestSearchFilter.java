package com.protom.mytime.dao.impl.filter;

public class RequestSearchFilter extends AbstractSearchFilter {

	private static final long serialVersionUID = -740514010938496975L;
	
	private Integer id;
	private Integer detailId;
	private Integer statusId;
	private String note;
	private Boolean taxi;
	private Boolean auto;
	
	public static RequestSearchFilter builder() {
		return new RequestSearchFilter();
	}
	
	public Integer getId() {
		return id;
	}
	public RequestSearchFilter setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public RequestSearchFilter setDetailId(Integer detailId) {
		this.detailId = detailId;
		return this;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public RequestSearchFilter setStatusId(Integer statusId) {
		this.statusId = statusId;
		return this;
	}
	public String getNote() {
		return note;
	}
	public RequestSearchFilter setNote(String note) {
		this.note = note;
		return this;
	}
	public Boolean getTaxi() {
		return taxi;
	}
	public RequestSearchFilter setTaxi(Boolean taxi) {
		this.taxi = taxi;
		return this;
	}
	public Boolean getAuto() {
		return auto;
	}
	public RequestSearchFilter setAuto(Boolean auto) {
		this.auto = auto;
		return this;
	}

}
