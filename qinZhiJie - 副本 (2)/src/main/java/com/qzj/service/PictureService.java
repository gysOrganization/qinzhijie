package com.qzj.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.BigPictureDao;
import com.qzj.dto.BigPicture;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class PictureService extends BaseTgService {

	@Autowired
	private BigPictureDao bigPictureDao;
	
	public PageResult<BigPicture> getList(PageRequest page){
		PageResult<BigPicture> pageResult = new PageResult<>();
		pageResult.setDataList(bigPictureDao.getList(page));
		pageResult.setTotal(bigPictureDao.getTotal(page));
		return pageResult;
	}
	
	public void add(BigPicture bigPicture){
		Date date = new Date();
		bigPicture.setCreateBy(Constant.SYS_USER);
		bigPicture.setCreateTime(date);
		bigPicture.setUpdateTime(date);
		bigPicture.setUpdateBy(Constant.SYS_USER);
		bigPictureDao.add(bigPicture);
	}
	
	public void update(BigPicture bigPicture){
		if(bigPicture.getId() == null) {
			return;
		}
		bigPicture.setUpdateTime(new Date());
		bigPicture.setUpdateBy(Constant.SYS_USER);
		bigPictureDao.update(bigPicture);
	}
	
	public void delete(String ids){
		if(StringUtils.isBlank(ids)) {
			return;
		}
		
		List<String> list = Arrays.asList(ids.split(","));
		bigPictureDao.delete(list);
	}
}
