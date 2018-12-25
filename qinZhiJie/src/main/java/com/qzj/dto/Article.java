package com.qzj.dto;

import com.qzj.entity.BaseTgEntity;

public class Article extends BaseTgEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2539606269516429059L;

	private String articleType;
	
	private String articleTitle;
	
	private String articleKeyWord;
	
	private String desc;
	
	private String articleText;

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleKeyWord() {
		return articleKeyWord;
	}

	public void setArticleKeyWord(String articleKeyWord) {
		this.articleKeyWord = articleKeyWord;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getArticleText() {
		return articleText;
	}

	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
}
