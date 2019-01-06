package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Member;
import com.qzj.dto.Musician;
import com.qzj.dto.PageRequest;

@Mapper
public interface MusicianDao {

	public long add(@Param(value="item") Musician list);
	
	public List<Member> getList(@Param(value="page") PageRequest page);
	
	public long getTotal(@Param(value="page") PageRequest page);
	
	public long delete(@Param(value="list") List<String> list);
}
