package com.qzj.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.BookLyric;
import com.qzj.dto.PageRequest;

@Mapper
public interface BookLyricDao {

	public long add(@Param(value="bookLyric") BookLyric bookLyric);
	
	List<BookLyric> selectList(HashMap<String, Object> map);
	
	public long update(@Param(value="bookLyric") BookLyric bookLyric);
	
	public List<BookLyric> getList(@Param(value="page") PageRequest<BookLyric> page);
	
	public long getTotal(@Param(value="page") PageRequest<BookLyric> page);
}
