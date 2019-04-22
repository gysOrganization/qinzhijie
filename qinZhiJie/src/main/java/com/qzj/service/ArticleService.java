package com.qzj.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.ArticleDao;
import com.qzj.dto.Article;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class ArticleService extends BaseTgService {

	@Autowired
	private ArticleDao articleDao;
	public PageResult<Article> getList(PageRequest<Article> page){
		PageResult<Article> pageResult = new PageResult<>();
		pageResult.setPageSize(page.getPageSize());
		pageResult.setDataList(articleDao.getList(page));
		pageResult.setTotal(articleDao.getTotal(page));
		return pageResult;
	}
	
	public void add(Article Article){
		Date date = new Date();
		Article.setCreateBy(Constant.SYS_USER);
		Article.setCreateTime(date);
		Article.setUpdateTime(date);
		Article.setUpdateBy(Constant.SYS_USER);
		articleDao.add(Article);
	}
	
	public void update(Article Article){
		if(Article.getId() == null) {
			return;
		}
		Article.setUpdateTime(new Date());
		Article.setUpdateBy(Constant.SYS_USER);
		articleDao.update(Article);
	}
	
	public void delete(String ids){
		if(StringUtils.isBlank(ids)) {
			return;
		}
		
		List<String> list = Arrays.asList(ids.split(","));
		articleDao.delete(list);
	}
}
