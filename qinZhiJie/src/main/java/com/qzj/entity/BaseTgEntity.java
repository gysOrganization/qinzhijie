package com.qzj.entity;

import java.io.Serializable;
import java.util.Date;

import com.qzj.entity.BaseTgEntity;

import lombok.Data;

@Data
public class BaseTgEntity implements Serializable {
	private static final long serialVersionUID = 4353881782501900516L;

	/** 主键优惠ID */
	private Long id;

	/** 创建时间 */
	private Date createTime;

	/** 修改时间 */
	private Date updateTime;
	
	/** 创建人 */
	private String createBy;
	
	/** 更新人 */
	private String updateBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
