package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Fingering;
import com.qzj.dto.PageRequest;

@Mapper
public interface FingeringDao {

	public List<Fingering> getList(@Param(value="page") PageRequest<Fingering> page);
	
	public long getTotal(@Param(value="page") PageRequest<Fingering> page);
	
	public long add(@Param(value="fingering") Fingering fingering);
	
	public long update(@Param(value="fingering") Fingering fingering);
	
	public long delete(@Param(value="list") List<String> list);
	
	public List<String> getPaintings();
	}
