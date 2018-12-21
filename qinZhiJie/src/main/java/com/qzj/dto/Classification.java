/*
 * 文 件 名:  Classification.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章分类
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Classification extends BaseTgEntity {

	private static final long serialVersionUID = 2441427198958139677L;

	/** 分类名称 **/
	private String name;

	/** 备注 **/
	private String remark;

	/** 父类Id **/
	private Long parentId;

	/** 排序 **/
	private Integer compositor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getCompositor() {
		return compositor;
	}

	public void setCompositor(Integer compositor) {
		this.compositor = compositor;
	}
}
