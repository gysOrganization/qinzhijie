package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.BigPicture;
import com.qzj.dto.PageRequest;

@Mapper
public interface BigPictureDao {

	public List<BigPicture> getList(@Param(value="page") PageRequest page);
	
	public long getTotal(@Param(value="page") PageRequest page);
	
	public long add(@Param(value="picture") BigPicture picture);
	
	public long update(@Param(value="picture") BigPicture picture);
	
	public long delete(@Param(value="list") List<String> list);
	}
