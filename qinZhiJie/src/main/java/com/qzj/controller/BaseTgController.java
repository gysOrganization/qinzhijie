/*
 * 文 件 名:  BaseTgController.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qzj.service.ClassificationService;
import com.qzj.service.InterlinkageService;
import com.qzj.service.UserService;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseTgController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected UserService uservice;

	@Autowired
	protected ClassificationService classService;

	@Autowired
	protected InterlinkageService linkService;

}
