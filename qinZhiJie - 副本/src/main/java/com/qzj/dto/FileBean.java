package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class FileBean extends BaseTgEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3495535657336968432L;
	private String uuid;
	private String path;
	private String name;
	private String fileType;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
