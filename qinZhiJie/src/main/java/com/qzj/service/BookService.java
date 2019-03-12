package com.qzj.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.BookDao;
import com.qzj.dto.Book;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;

@Service
public class BookService extends BaseTgService {

	@Autowired
	private BookDao bookDao;

	public PageResult<Book> getList(PageRequest<Book> page) {
		if (page != null && null != page.getQueryObj()) {
			Book book = page.getQueryObj();
			if (StringUtils.isNotBlank(book.getBookName())) {
				book.setBookName("%" + book.getBookName() + "%");
			}
			if (StringUtils.isNotBlank(book.getYear())) {
				book.setYear("%" + book.getYear() + "%");
			}
			if (StringUtils.isNotBlank(book.getDynasty())) {
				book.setDynasty("%" + book.getDynasty() + "%");
			}
			if (StringUtils.isNotBlank(book.getAuthor())) {
				book.setAuthor("%" + book.getAuthor() + "%");
			}
			if (StringUtils.isNotBlank(book.getDirPath())) {
				book.setDirPath("%" + book.getDirPath() + "%");
			}
			page.setQueryObj(book);
		}
		PageResult<Book> pageResult = new PageResult<>();
		pageResult.setDataList(bookDao.getList(page));
		pageResult.setTotal(bookDao.getTotal(page));
		return pageResult;
	}
}
