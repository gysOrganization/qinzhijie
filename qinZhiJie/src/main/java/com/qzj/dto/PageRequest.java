package com.qzj.dto;

public class PageRequest {

	private long currentPage = 1;
	
	private long pageSize = 20;
	
	private long startIndex;

	public long getStartIndex() {
		startIndex = (1 - currentPage) * pageSize;
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
}
