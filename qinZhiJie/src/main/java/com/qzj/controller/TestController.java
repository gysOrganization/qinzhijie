package com.qzj.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;

/**
 * 用户接口
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestController {
	@RequestMapping("/test")
	public ResponseData<String> addUser() {
		ResponseData<String> resp = new ResponseData<>();
		resp.setData("hello world!!");
		return resp;
	}
}
