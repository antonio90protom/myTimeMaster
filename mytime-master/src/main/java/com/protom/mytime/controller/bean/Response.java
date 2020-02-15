package com.protom.mytime.controller.bean;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = -3217681406157805698L;

	private Long total;
	private Integer records;
	private Integer status;
	private String statusMessage;
	private T payload;
	
	public Long getTotal() {
		return total;
	}
	public Response<T> setTotal(Long total) {
		this.total = total;
		return this;
	}
	public Integer getRecords() {
		return records;
	}
	public Response<T> setRecords(Integer records) {
		this.records = records;
		return this;
	}
	public Integer getStatus() {
		return status;
	}
	public Response<T> setStatus(Integer status) {
		this.status = status;
		return this;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public Response<T> setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		return this;
	}
	public Response<T> setStatusMessage(String statusMessage, Throwable e) {
		this.statusMessage = statusMessage + e.getMessage();
		return this;
	}
	public T getPayload() {
		return payload;
	}
	public Response<T> setPayload(T payload) {
		this.payload = payload;
		return this;
	}
}
