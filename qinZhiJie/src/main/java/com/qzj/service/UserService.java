/*
 * 文 件 名:  UserService.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qzj.commos.exception.BizException;
import com.qzj.dto.User;

/**
 * 用户逻辑
 * 
 * @author  Muffler7
 * @version  [版本号, 2018年10月28日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UserService extends BaseTgService
{
    
   /**
    *  创建用户
    * @param user
    * @return
    * @see [类、类#方法、类#成员]
    */
   public Map<String, Object> addUser(User user)
   {
       if(user==null)
       {
           throw new BizException("user is null",null,new HashMap<>());
       }
       
       if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword()))
       {
           throw new BizException("用户名和密码不能为空!",null,new HashMap<>());
       }
       
       //查询数据库是否有已存在的账号
       User u = userDao.userInfo(user.getUsername());
       if(u!=null)
       {
           throw new BizException("用户名已存在,请重新设置!",null,new HashMap<>());
       }
       
       user.setCreateTime(new Date());
       
       userDao.addUser(user);
       
       return new HashMap<>();
   }
   
   
   /**
    *  更新用户
    * @param user
    * @return
    * @see [类、类#方法、类#成员]
    */
   public Map<String, Object> updateUser(User user)
   {
       if(user==null)
       {
           throw new BizException("user is null",null,new HashMap<>());
       }
       
       if(user.getId()==null||user.getId()<=0)
       {
           throw new BizException("userId is null",null,new HashMap<>());
       }
       
       //只更新密码，邮箱，电话，真实名字，更新时更新时间
       user.setUpdateTime(new Date());
       user.setLastLoginTime(null);
       user.setCreateTime(null);
       
       userDao.updateUser(user);
       
       return new HashMap<>();
   }
   
   /**
    *  更新用户
    * @param id
    * @return
    * @see [类、类#方法、类#成员]
    */
   public Map<String, Object> deleteUser(Long id)
   {
       if(id==null||id<=0)
       {
           throw new BizException("userId is null",null,new HashMap<>());
       }
      
       int d =userDao.deleteUser(id);
       
       logger.info(" -- delete User --"+id+"  -- return "+d);
       
       return new HashMap<>();
   }
   
   
   /**
    *  更新用户
    * @param user
    * @return
    * @see [类、类#方法、类#成员]
    */
   public Map<String, Object> login(User user)
   {
       if(user==null)
       {
           throw new BizException("user is null",null,new HashMap<>());
       }
             
       if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword()))
       {
           throw new BizException("用户名和密码不能为空!",null,new HashMap<>());
       }
       
       //查询数据库是否有已存在的账号
       User u = userDao.userInfo(user.getUsername());
       if(u==null)
       {
           throw new BizException("用户名不存在,请重新输入!",null,new HashMap<>());
       }
       if(!user.getPassword().equals(u.getPassword()))
       {
           throw new BizException("用户名或密码错误,请重新输入!",null,new HashMap<>());
       }
       
       User uu = new User();
       uu.setLastLoginTime(new Date());
       uu.setId(u.getId());
       //更新登录时间
       userDao.updateUser(uu);
       
       return new HashMap<>();
   }
   
    
    
}
