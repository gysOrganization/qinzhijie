/*
 * 文 件 名:  InterlinkageDao.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.dao;

import java.util.HashMap;
import java.util.List;

import com.qzj.dto.Interlinkage;

/**
 * dao
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface InterlinkageDao {
	void addLink(Interlinkage link);

	int deleteLink(Long id);

	int updateLink(Interlinkage link);

	List<Interlinkage> selectList(HashMap<String, Object> map);

	int countList(HashMap<String, Object> map);
}
