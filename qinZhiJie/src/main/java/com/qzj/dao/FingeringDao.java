package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Article;
import com.qzj.dto.Fingering;
import com.qzj.dto.PageRequest;

@Mapper
public interface FingeringDao {

	public List<Article> getList(@Param(value="page") PageRequest page);
	
	public long getTotal(@Param(value="page") PageRequest page);
	
	public long add(@Param(value="fingering") Fingering fingering);
	
	public long update(@Param(value="fingering") Fingering fingering);
	
	public long delete(@Param(value="list") List<String> list);
	}
