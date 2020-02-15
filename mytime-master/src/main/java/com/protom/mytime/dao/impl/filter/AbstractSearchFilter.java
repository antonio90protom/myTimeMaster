package com.protom.mytime.dao.impl.filter;

import java.io.Serializable;

public abstract class AbstractSearchFilter implements Serializable {

	private static final long serialVersionUID = 4502873782436396771L;

	private Integer page;
	private Integer pageSize;
	
	public Integer getPage() {
		return page;
	}
	public AbstractSearchFilter setPage(Integer page) {
		this.page = page;
		return this;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public AbstractSearchFilter setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	
}
