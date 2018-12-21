package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Member;
import com.qzj.dto.PageRequest;

@Mapper
public interface MemberDao {

	List<Member> getList(@Param(value="page") PageRequest page);
	
	long getTotal();
	}
