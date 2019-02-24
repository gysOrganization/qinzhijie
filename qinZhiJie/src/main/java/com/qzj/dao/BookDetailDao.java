package com.qzj.dao;

import org.apache.ibatis.annotations.Param;

import com.qzj.dto.BookDetail;

public interface BookDetailDao {

	public long add(@Param(value="bookDetail") BookDetail bookDetail);
}
