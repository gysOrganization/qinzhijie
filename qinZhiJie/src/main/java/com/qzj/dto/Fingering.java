package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class Fingering extends BaseTgEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2539606269516429059L;

	private String name;
	
	private Integer paintings;
	
	private String desc;
	
	private String content;
	
	private String fileUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPaintings() {
		return paintings;
	}

	public void setPaintings(Integer paintings) {
		this.paintings = paintings;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
