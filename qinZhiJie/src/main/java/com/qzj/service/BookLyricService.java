package com.qzj.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.BookLyricDao;
import com.qzj.dto.BookLyric;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class BookLyricService extends BaseTgService {

	@Autowired
	private BookLyricDao bookLyricDao;

	public PageResult<BookLyric> getList(PageRequest<BookLyric> page) {
		if (page != null && null != page.getQueryObj()) {
			BookLyric bookLyric = page.getQueryObj();
			if (StringUtils.isNotBlank(bookLyric.getMusicofviolin())) {
				bookLyric.setMusicofviolin("%" + bookLyric.getMusicofviolin() + "%");
			}
			if (StringUtils.isNotBlank(bookLyric.getDesc())) {
				bookLyric.setDesc("%" + bookLyric.getDesc() + "%");
			}
			page.setQueryObj(bookLyric);
		}
		PageResult<BookLyric> pageResult = new PageResult<>();
		pageResult.setPageSize(page.getPageSize());
		pageResult.setDataList(bookLyricDao.getList(page));
		pageResult.setPageSize(page.getPageSize());
		pageResult.setTotal(bookLyricDao.getTotal(page));
		return pageResult;
	}
}
