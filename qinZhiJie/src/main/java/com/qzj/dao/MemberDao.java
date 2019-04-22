package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Member;
import com.qzj.dto.PageRequest;

@Mapper
public interface MemberDao {

	@SuppressWarnings("rawtypes")
    public List<Member> getList(@Param(value="page") PageRequest page);
	
	@SuppressWarnings("rawtypes")
    public long getTotal(@Param(value="page") PageRequest page);
	
	public long add(@Param(value="member") Member member);
	
	public long update(@Param(value="member") Member member);
	
	public long delete(@Param(value="list") List<String> list);
	}
