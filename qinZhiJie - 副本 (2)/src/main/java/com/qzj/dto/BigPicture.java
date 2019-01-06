package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class BigPicture extends BaseTgEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994162144071737978L;

	private String type;
	
	private String pictureName;
	
	private String pictureUrl;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
