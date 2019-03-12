package com.qzj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qzj.dto.Article;
import com.qzj.dto.PageRequest;

@Mapper
public interface ArticleDao {

	public List<Article> getList(@Param(value="page") PageRequest<Article> page);
	
	public long getTotal(@Param(value="page") PageRequest<Article> page);
	
	public long add(@Param(value="article") Article Article);
	
	public long update(@Param(value="article") Article Article);
	
	public long delete(@Param(value="list") List<String> list);
	}
