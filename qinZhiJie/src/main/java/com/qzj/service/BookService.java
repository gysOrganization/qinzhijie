package com.qzj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.dao.BookDao;
import com.qzj.dto.Book;
import com.qzj.dto.PageResult;

@Service
public class BookService extends BaseTgService {
	
	@Autowired
	private BookDao bookDao;
	
	public PageResult<Book> findByBookName(String bookName){
		PageResult<Book> result = new PageResult<>();
		//bookDao.selectList(map)
		return null;
	}
}
