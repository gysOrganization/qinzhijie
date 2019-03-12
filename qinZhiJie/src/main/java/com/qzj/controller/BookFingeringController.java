package com.qzj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.Fingering;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.FingeringService;

@CrossOrigin
@RestController
@RequestMapping("/bookFingering")
public class BookFingeringController extends BaseTgController {
	
	@Autowired
	private FingeringService fingeringService;

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<Fingering>> getList(@RequestBody PageRequest<Fingering> page, HttpServletRequest request) {
		ResponseData<PageResult<Fingering>> result = new ResponseData<PageResult<Fingering>>();
		result.setData(fingeringService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
