package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class Member extends BaseTgEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237739939166660334L;
	private String type;

	private String name;

	private String pictureLink;

	private String profile;

	private String desc;
	
	

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

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
