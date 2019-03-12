package com.qzj.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.BookDetailDao;
import com.qzj.dto.BookDetail;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class BookDetailService extends BaseTgService {

	@Autowired
	private BookDetailDao bookDetailDao;

	public PageResult<BookDetail> getList(PageRequest<BookDetail> page) {
		if (page != null && null != page.getQueryObj()) {
			BookDetail bookDetail = page.getQueryObj();
			if (StringUtils.isNotBlank(bookDetail.getPartName())) {
				bookDetail.setPartName("%" + bookDetail.getPartName() + "%");
			}
			if (StringUtils.isNotBlank(bookDetail.getDirPath())) {
				bookDetail.setDirPath("%" + bookDetail.getDirPath() + "%");
			}
			page.setQueryObj(bookDetail);
		}
		PageResult<BookDetail> pageResult = new PageResult<>();
		pageResult.setDataList(bookDetailDao.getList(page));
		pageResult.setTotal(bookDetailDao.getTotal(page));
		return pageResult;
	}
}
