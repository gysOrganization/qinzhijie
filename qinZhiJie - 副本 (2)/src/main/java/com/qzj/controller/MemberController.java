package com.qzj.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<Member>> memberList(@RequestBody PageRequest page, HttpServletRequest request) {
		ResponseData<PageResult<Member>> result = new ResponseData<PageResult<Member>>();
		result.setData(memberService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData<PageResult<Member>> add(@RequestBody Member member, HttpServletRequest request) {
		ResponseData<PageResult<Member>> result = new ResponseData<PageResult<Member>>();
		memberService.add(member);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseData<PageResult<Member>> update(@RequestBody Member member, HttpServletRequest request) {
		ResponseData<PageResult<Member>> result = new ResponseData<PageResult<Member>>();
		memberService.update(member);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseData<PageResult<Member>> delete(@RequestParam String ids, HttpServletRequest request) {
		ResponseData<PageResult<Member>> result = new ResponseData<PageResult<Member>>();
		memberService.delete(ids);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
