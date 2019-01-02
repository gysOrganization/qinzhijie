package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.FileBean;

@Mapper
public interface FileDao {

/*	public List<FileBean> getList(@Param(value="page") PageRequest page);
	
	public long getTotal(@Param(value="page") PageRequest page);*/
	
	public FileBean getByUuid(@Param(value="uuid") String uuid);
	
	public long add(@Param(value="fileBean") FileBean fileBean);
	
	public long delete(@Param(value="list") List<String> list);
	}
