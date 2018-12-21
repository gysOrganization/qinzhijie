package com.qzj.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.Member;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.MemberService;

/**
 * 会员管理接口
 * 
 * @author YuanSongGong
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseTgController {

	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public ResponseData<PageResult<Member>> memberList(PageRequest page, HttpServletRequest request) {
		ResponseData<PageResult<Member>> result = new ResponseData<PageResult<Member>>();
		result.setData(memberService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
