package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qzj.dto.BookDetail;
import com.qzj.dto.PageRequest;

public interface BookDetailDao {

	public long add(@Param(value="bookDetail") BookDetail bookDetail);
	
	public List<BookDetail> getList(@Param(value="page") PageRequest<BookDetail> page);
	
	public long getTotal(@Param(value="page") PageRequest<BookDetail> page);
	
	public long update(@Param(value="bookDetail") BookDetail bookDetail);
}
