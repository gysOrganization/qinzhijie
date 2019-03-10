package com.qzj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dao.BookDao;
import com.qzj.dto.Article;
import com.qzj.dto.Book;
import com.qzj.dto.Classification;
import com.qzj.dto.PageResult;
import com.qzj.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController extends BaseTgController {
	
	@Autowired
	BookService service;

/*	@RequestMapping("/findByBookName")
	public ResponseData<PageResult<Book>> findByBookName(@RequestParam(required = true) String bookName) {
		ResponseData<PageResult<Book>> result = new ResponseData<PageResult<Book>>();
		if (StringUtils.isBlank(bookName)) {
			result.setCode("200");
			result.setMessage("no parameter");
			return result;
		}
		return service.findByBookName(bookName);
	}*/
}
