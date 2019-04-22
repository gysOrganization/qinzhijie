package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class Book extends BaseTgEntity{

	/**
	 * t_book， 书名
	 */
	private static final long serialVersionUID = -2539606269516429059L;
	
	private String bookName;
	
	private String year;
	
	private String dynasty;
	
	private String author;
	
	private String dirPath;

	private Integer orderNum;
	
	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}
