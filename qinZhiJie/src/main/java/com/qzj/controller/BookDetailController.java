package com.qzj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.BookDetail;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.BookDetailService;

@CrossOrigin
@RestController
@RequestMapping("/bookDetail")
public class BookDetailController extends BaseTgController {
	
	@Autowired
	private BookDetailService bookDetailService;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<BookDetail>> getList(@RequestBody PageRequest<BookDetail> page, HttpServletRequest request) {
		ResponseData<PageResult<BookDetail>> result = new ResponseData<PageResult<BookDetail>>();
		result.setData(bookDetailService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
