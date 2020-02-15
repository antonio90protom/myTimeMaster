package com.protom.mytime.dao.impl.filter;

public class TimeSearchFilter extends AbstractSearchFilter {

	private static final long serialVersionUID = 6564836773977041507L;
	
	private Integer id;
	private String ownerUsername;
	private String approverUsername;
	private Integer idStatus;
	private Integer year;
	private Integer month;
	private Integer period;
	private Integer idRequestStatus;
	private Boolean approvation;
	
	public static TimeSearchFilter builder() {
		return new TimeSearchFilter();
	}
	public Integer getId() {
		return id;
	}
	public TimeSearchFilter setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public TimeSearchFilter setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
		return this;
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public TimeSearchFilter setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
		return this;
	}
	public Integer getYear() {
		return year;
	}
	public TimeSearchFilter setYear(Integer year) {
		this.year = year;
		return this;
	}
	public Integer getMonth() {
		return month;
	}
	public TimeSearchFilter setMonth(Integer month) {
		this.month = month;
		return this;
	}
	public Integer getPeriod() {
		return period;
	}
	public TimeSearchFilter setPeriod(Integer period) {
		this.period = period;
		return this;
	}
	public Integer getIdRequestStatus() {
		return idRequestStatus;
	}
	public TimeSearchFilter setIdRequestStatus(Integer idRequestStatus) {
		this.idRequestStatus = idRequestStatus;
		return this;
	}
	public String getApproverUsername() {
		return approverUsername;
	}
	public TimeSearchFilter setApproverUsername(String approverUsername) {
		this.approverUsername = approverUsername;
		return this;
	}
	@Override
	public String toString() {
		return "TimeSearchFilter [id=" + id + ", ownerUsername=" + ownerUsername + ", approverUsername="
				+ approverUsername + ", idStatus=" + idStatus + ", year=" + year + ", month=" + month + ", period="
				+ period + ", idRequestStatus=" + idRequestStatus + "]";
	}
	public Boolean getApprovation() {
		return approvation;
	}
	public TimeSearchFilter setApprovation(Boolean approvation) {
		this.approvation = approvation;
		return this;
	}

}
