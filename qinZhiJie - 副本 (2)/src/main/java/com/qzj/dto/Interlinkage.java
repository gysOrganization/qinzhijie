/*
 * 文 件 名:  Interlinkage.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 友情链接
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Interlinkage extends BaseTgEntity {

	private static final long serialVersionUID = -5822973200733309741L;

	/** 类型 **/
	private String type;

	/** 名字 **/
	private String name;

	/** 地址 **/
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
