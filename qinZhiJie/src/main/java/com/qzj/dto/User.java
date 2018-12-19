/*
 * 文 件 名:  User.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.dto;

import java.util.Date;

import com.qzj.entity.BaseTgEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 * 
 * @author  Muffler7
 * @version  [版本号, 2018年10月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends BaseTgEntity
{
    private static final long serialVersionUID = 2385533270108634361L;
    
    /**用户名**/
    private String username;
    
    /**密码**/
    private String password;
    
    /**电话**/
    private String telephone;
    
    /**真实姓名**/
    private String trueName;
    
    /**邮箱**/
    private String email;
    
    /**是否是admin**/
    private Integer isAdmin;
    
    /**是否是admin**/
    private Date lastLoginTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
