package com.qzj.dto;

public class PageRequest {

	private long currentPage = 1;

	private long pageSize = 20;

	// 查询对象
	private Object queryObj;

	private long startIndex;

	public long getStartIndex() {
		startIndex = (currentPage - 1) * pageSize;
		return startIndex;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public Object getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(Object queryObj) {
		this.queryObj = queryObj;
	}
}
