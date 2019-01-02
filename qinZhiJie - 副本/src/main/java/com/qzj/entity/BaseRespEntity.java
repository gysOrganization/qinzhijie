package com.qzj.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * 返回格式化
 * 
 * @author Muffler7
 * @version [版本号, 2018年11月8日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
public class BaseRespEntity implements Serializable {

	private static final long serialVersionUID = 6556318843669012812L;

	/** 主键优惠ID */
	public Long id;

	/** 创建时间 */
	public String createTime;

	/** 修改时间 */
	public String updateTime;

	public Integer pageNo;

	public Integer pageSize;

}
