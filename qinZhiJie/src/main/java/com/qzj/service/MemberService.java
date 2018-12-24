package com.qzj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.MemberDao;
import com.qzj.dto.Member;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class MemberService extends BaseTgService {

	@Autowired
	private MemberDao memberDao;
	public PageResult<Member> getList(PageRequest page){
		PageResult<Member> pageResult = new PageResult<>();
		pageResult.setDataList(memberDao.getList(page));
		pageResult.setTotal(memberDao.getTotal(page));
		return pageResult;
	}
	
	public void add(Member member){
		memberDao.add(member);
	}
}
