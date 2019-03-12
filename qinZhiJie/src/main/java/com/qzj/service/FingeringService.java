package com.qzj.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.FingeringDao;
import com.qzj.dto.Fingering;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class FingeringService extends BaseTgService {

	@Autowired
	private FingeringDao fingeringDao;

	public PageResult<Fingering> getList(PageRequest<Fingering> page) {
		if (page != null && null != page.getQueryObj()) {
			Fingering fingering = page.getQueryObj();
			if (StringUtils.isNotBlank(fingering.getName())) {
				fingering.setName("%" + fingering.getName() + "%");
			}
			if (StringUtils.isNotBlank(fingering.getContent())) {
				fingering.setContent("%" + fingering.getContent() + "%");
			}
			if (StringUtils.isNotBlank(fingering.getFileUrl())) {
				fingering.setFileUrl("%" + fingering.getFileUrl() + "%");
			}
			if (StringUtils.isNotBlank(fingering.getDesc())) {
				fingering.setDesc("%" + fingering.getDesc() + "%");
			}
			page.setQueryObj(fingering);
		}
		PageResult<Fingering> pageResult = new PageResult<>();
		pageResult.setPageSize(page.getPageSize());
		pageResult.setDataList(fingeringDao.getList(page));
		pageResult.setPageSize(page.getPageSize());
		pageResult.setTotal(fingeringDao.getTotal(page));
		return pageResult;
	}
	
	public PageResult<String> getPaintings(){
		PageResult<String> pageResult = new PageResult<>();
		pageResult.setDataList(fingeringDao.getPaintings());
		return pageResult;
	}
}
