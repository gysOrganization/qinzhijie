package com.qzj.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Book;

@Mapper
public interface BookDao {

	public long add(@Param(value="book") Book book);
	
	List<Book> selectList(HashMap<String, Object> map);
	
	public Integer selectMaxId();
	
	public long update(@Param(value="book") Book book);
}
