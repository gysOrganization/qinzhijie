package com.qzj.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.MemberDao;
import com.qzj.dto.Member;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class MemberService extends BaseTgService {

	@Autowired
	private MemberDao memberDao;
	public PageResult<Member> getList(PageRequest<Member> page){
		PageResult<Member> pageResult = new PageResult<>();
		pageResult.setPageSize(page.getPageSize());
		pageResult.setDataList(memberDao.getList(page));
		pageResult.setTotal(memberDao.getTotal(page));
		return pageResult;
	}
	
	public void add(Member member){
		Date date = new Date();
		member.setCreateBy(Constant.SYS_USER);
		member.setCreateTime(date);
		member.setUpdateTime(date);
		member.setUpdateBy(Constant.SYS_USER);
		memberDao.add(member);
	}
	
	public void update(Member member){
		if(member.getId() == null) {
			return;
		}
		member.setUpdateTime(new Date());
		member.setUpdateBy(Constant.SYS_USER);
		memberDao.update(member);
	}
	
	public void delete(String ids){
		if(StringUtils.isBlank(ids)) {
			return;
		}
		
		List<String> list = Arrays.asList(ids.split(","));
		memberDao.delete(list);
	}
}
