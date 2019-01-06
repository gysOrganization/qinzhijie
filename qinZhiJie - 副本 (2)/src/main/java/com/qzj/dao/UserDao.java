/*
 * 文 件 名:  UserDao.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.dao;

import java.util.HashMap;
import java.util.List;

import com.qzj.dto.User;

/**
 * 用户登录
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UserDao {
	void addUser(User user);

	int deleteUser(Long id);

	int updateUser(User user);

	int countUser(HashMap<String, Object> map);

	List<User> seletUserList(HashMap<String, Object> map);

	User userInfo(String username);

}
