package com.qzj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.PageResult;
import com.qzj.service.ImportMusician;

@RestController
@RequestMapping("/ImportDataTo")
public class ImportDataToDBController {

	@Autowired
	private ImportMusician importMusican;

	@RequestMapping(value = "/musician", method = RequestMethod.POST)
	public ResponseData<PageResult<String>> musician(){
		ResponseData<PageResult<String>> result = new ResponseData<PageResult<String>>();
		importMusican.importMusican();
		result.setCode("200");
		result.setMessage("success");
		return result;
	}
	
	
}
