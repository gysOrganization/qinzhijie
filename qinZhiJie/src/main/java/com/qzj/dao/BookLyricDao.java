package com.qzj.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.BookLyric;

@Mapper
public interface BookLyricDao {

	public long add(@Param(value="bookLyric") BookLyric bookLyric);
	
	List<BookLyric> selectList(HashMap<String, Object> map);
	
	public long update(@Param(value="bookLyric") BookLyric bookLyric);
}
