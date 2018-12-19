/*
 * 文 件 名:  UserController.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.dto.User;
import com.qzj.util.ObjectUtil;



/**
 * 用户接口
 * 
 * @author  Muffler7
 * @version  [版本号, 2018年10月28日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController extends BaseTgController
{
    @RequestMapping("/add")
    public Map<String, Object> addUser(@RequestBody Map<String,Object> request)
    {
        User user = ObjectUtil.parseMap2Object(request,User.class);
        
        return uservice.addUser(user);
                
    }
    
    @RequestMapping("/update")
    public Map<String, Object> updateUser(@RequestBody Map<String,Object> request)
    {
        User user = ObjectUtil.parseMap2Object(request,User.class);
        
        return uservice.updateUser(user);
                
    }
    
    @RequestMapping("/delete")
    public Map<String, Object> deleteUser(@RequestBody Map<String,Object> request)
    {
        Long id = request.get("id")==null?null:Long.parseLong(String.valueOf(request.get("id")));
        
        return uservice.deleteUser(id);
                
    }
    
    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,Object> request)
    {
        User user = ObjectUtil.parseMap2Object(request,User.class);
        
        return uservice.login(user);
                
    }
    
}
