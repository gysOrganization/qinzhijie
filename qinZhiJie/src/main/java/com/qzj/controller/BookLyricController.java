package com.qzj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.BookLyric;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.BookLyricService;

@CrossOrigin
@RestController
@RequestMapping("/bookLyric")
public class BookLyricController extends BaseTgController {
	
	@Autowired
	private BookLyricService bookLyricService;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<BookLyric>> getList(@RequestBody PageRequest<BookLyric> page, HttpServletRequest request) {
		ResponseData<PageResult<BookLyric>> result = new ResponseData<PageResult<BookLyric>>();
		result.setData(bookLyricService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
