package com.qzj.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.Article;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.ArticleService;

/**
 * 会员管理接口
 * 
 * @author YuanSongGong
 *
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseTgController {

	
	@Autowired
	private ArticleService ArticleService;
	
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<Article>> getList(@RequestBody PageRequest page, HttpServletRequest request) {
		ResponseData<PageResult<Article>> result = new ResponseData<PageResult<Article>>();
		result.setData(ArticleService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData<PageResult<Article>> add(@RequestBody Article Article, HttpServletRequest request) {
		ResponseData<PageResult<Article>> result = new ResponseData<PageResult<Article>>();
		ArticleService.add(Article);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseData<PageResult<Article>> update(@RequestBody Article Article, HttpServletRequest request) {
		ResponseData<PageResult<Article>> result = new ResponseData<PageResult<Article>>();
		ArticleService.update(Article);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseData<PageResult<Article>> delete(@RequestParam String ids, HttpServletRequest request) {
		ResponseData<PageResult<Article>> result = new ResponseData<PageResult<Article>>();
		ArticleService.delete(ids);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
