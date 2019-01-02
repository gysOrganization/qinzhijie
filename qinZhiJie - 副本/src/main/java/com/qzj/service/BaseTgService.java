/*
 * 文 件 名:  BaseTgService.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qzj.dao.ClassificationDao;
import com.qzj.dao.InterlinkageDao;
import com.qzj.dao.UserDao;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseTgService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected ClassificationDao classDao;

	@Autowired
	protected UserDao userDao;

	@Autowired
	protected InterlinkageDao linkDao;

}
