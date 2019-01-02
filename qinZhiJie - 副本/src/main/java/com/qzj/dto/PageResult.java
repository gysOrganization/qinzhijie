package com.qzj.dto;

import java.util.List;

public class PageResult<T> {
	
	private List<T> dataList;

	private long currentPage = 1;
	
	private long pageSize = 20;
	
	/** 縂頁數 */
	private long totalPageSize;
	
	/** 縂條數 */
	private long total;

	public long getTotalPageSize() {
		totalPageSize = total%pageSize == 0 ? total/pageSize:(total/pageSize) + 1;
		return totalPageSize;
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

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
