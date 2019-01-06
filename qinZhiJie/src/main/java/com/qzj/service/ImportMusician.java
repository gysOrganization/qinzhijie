package com.qzj.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.MusicianDao;
import com.qzj.dto.Musician;
import com.qzj.dto.PageRequest;

@Service
public class ImportMusician {

	@Autowired
	private MusicianDao musicianDao;

	public void importMusican() {
		String dirPath = "Z:\\01资料馆\\04琴百科\\琴人\\琴人名录";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (".txt".equals(f.getName().substring(f.getName().lastIndexOf(".")))) {
					Musician musician = new Musician();
					musician.setName(f.getName().substring(0, f.getName().lastIndexOf(".")));
					musician.setDesc(getStringFromFile(f));
					musician.setDescUrl(dirPath + "\\" + f.getName());
					musician.setUpdateBy(Constant.SYS_USER);
					musician.setCreateBy(Constant.SYS_USER);
					musician.setUpdateTime(date);
					musician.setCreateTime(date);
					musicianDao.add(musician);
				}
				
			}
		}
	}
	
	//导入琴人整合这个文件夹里的数据
	public void ipmortMusicianPic1() {
		String dirPath = "Z:\\06听古琴\\琴人\\01琴人整合";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (".jpg".equals(f.getName().substring(f.getName().lastIndexOf(".")))) {
					Musician musician = new Musician();
					musician.setName(f.getName().substring(0, f.getName().lastIndexOf(".")));
					
					//看当前这个人在数据库存在不
					PageRequest page = new PageRequest();
					page.setQueryObj(musician);
					List<Musician> list = musicianDao.getList(page);
					if(list == null || list.size() == 0){
						//如果数据库不存在就新增
						musician.setDesc("");
						musician.setDescUrl("");
						musician.setPicUrl1(dirPath + "\\" + f.getName());
						musician.setUpdateBy(Constant.SYS_USER);
						musician.setCreateBy(Constant.SYS_USER);
						musician.setUpdateTime(date);
						musician.setCreateTime(date);
						musicianDao.add(musician);
					}
					else {
						//如果存在就更新
						musician = list.get(0);
						musician.setPicUrl1(dirPath + "\\" + f.getName());
						musician.setUpdateTime(new Date());
						musicianDao.update(musician);
					}
				}
			}
		}
	}
	
	//导入(Z:\\06听古琴\\琴人\\800X800)对应的图片
	public void ipmortMusicianPic2() {
		String dirPath = "Z:\\06听古琴\\琴人\\800X800";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (".jpg".equals(f.getName().substring(f.getName().lastIndexOf(".")))) {
					Musician musician = new Musician();
					musician.setName(f.getName().substring(0, f.getName().lastIndexOf(".")));
					
					//看当前这个人在数据库存在不
					PageRequest page = new PageRequest();
					page.setQueryObj(musician);
					List<Musician> list = musicianDao.getList(page);
					if(list == null || list.size() == 0){
						//如果数据库不存在就新增
						musician.setDesc("");
						musician.setDescUrl("");
						musician.setPicUrl2(dirPath + "\\" + f.getName());
						musician.setUpdateBy(Constant.SYS_USER);
						musician.setCreateBy(Constant.SYS_USER);
						musician.setUpdateTime(date);
						musician.setCreateTime(date);
						musicianDao.add(musician);
					}
					else {
						//如果存在就更新
						musician = list.get(0);
						musician.setPicUrl2(dirPath + "\\" + f.getName());
						musician.setUpdateTime(new Date());
						musicianDao.update(musician);
					}
				}
			}
		}
	}
	
	//导入(Z:\06听古琴\琴人\1200X1200)对应的图片
	public void ipmortMusicianPic3() {
		String dirPath = "Z:\\06听古琴\\琴人\\1200X1200";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (".jpg".equals(f.getName().substring(f.getName().lastIndexOf(".")))) {
					Musician musician = new Musician();
					musician.setName(f.getName().substring(0, f.getName().lastIndexOf(".")));
					
					//看当前这个人在数据库存在不
					PageRequest page = new PageRequest();
					page.setQueryObj(musician);
					List<Musician> list = musicianDao.getList(page);
					if(list == null || list.size() == 0){
						//如果数据库不存在就新增
						musician.setDesc("");
						musician.setDescUrl("");
						musician.setPicUrl3(dirPath + "\\" + f.getName());
						musician.setUpdateBy(Constant.SYS_USER);
						musician.setCreateBy(Constant.SYS_USER);
						musician.setUpdateTime(date);
						musician.setCreateTime(date);
						musicianDao.add(musician);
					}
					else {
						//如果存在就更新
						musician = list.get(0);
						musician.setPicUrl3(dirPath + "\\" + f.getName());
						musician.setUpdateTime(new Date());
						musicianDao.update(musician);
					}
				}
			}
		}
	}
	
	//导入(Z:\06听古琴\琴人\1600X1600)对应的图片
	public void ipmortMusicianPic4() {
		String dirPath = "Z:\\06听古琴\\琴人\\1600X1600";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if (".jpg".equals(f.getName().substring(f.getName().lastIndexOf(".")))) {
					Musician musician = new Musician();
					musician.setName(f.getName().substring(0, f.getName().lastIndexOf(".")));
					
					//看当前这个人在数据库存在不
					PageRequest page = new PageRequest();
					page.setQueryObj(musician);
					List<Musician> list = musicianDao.getList(page);
					if(list == null || list.size() == 0){
						//如果数据库不存在就新增
						musician.setDesc("");
						musician.setDescUrl("");
						musician.setPicUrl4(dirPath + "\\" + f.getName());
						musician.setUpdateBy(Constant.SYS_USER);
						musician.setCreateBy(Constant.SYS_USER);
						musician.setUpdateTime(date);
						musician.setCreateTime(date);
						musicianDao.add(musician);
					}
					else {
						//如果存在就更新
						musician = list.get(0);
						musician.setPicUrl4(dirPath + "\\" + f.getName());
						musician.setUpdateTime(new Date());
						musicianDao.update(musician);
					}
				}
			}
		}
	}
	
	//导入(Z:\\06听古琴\\琴人)这里面的对应名字的文件夹的数据（就是除去上面1到4的文件夹的余下部分）
	public void ipmortMusicianPic5() {
		String dirPath = "Z:\\06听古琴\\琴人";
		File dir = new File(dirPath);
		if (dir != null && dir.isDirectory()) {
			File[] fileList = dir.listFiles();
			Date date = new Date();
			for (int i = 0; i < fileList.length; i++) {
				File f = fileList[i];
				if("01琴人整合,800X800,1200X1200,1600X1600".contains(f.getName()) && !f.isDirectory()){
					continue;
				}
				String name = "";
				if(f.getName().contains("-")){
					name = f.getName().substring(0, f.getName().indexOf("-"));
				}else{
					name = f.getName();
				}
				File[] subFile = f.listFiles();
				StringBuilder sb = new StringBuilder();
				if(subFile != null && 0 != subFile.length){
					for(int j = 0; j < subFile.length; j++){
						if(subFile[j].getName().contains(".jpg") || subFile[j].getName().contains(".png") ){
							sb.append(subFile[j]).append(",");
						}
					}
				}
				Musician musician = new Musician();
				musician.setName(name);
				//看当前这个人在数据库存在不
				PageRequest page = new PageRequest();
				page.setQueryObj(musician);
				List<Musician> list = musicianDao.getList(page);
				if(list == null || list.size() == 0){
					//如果数据库不存在就新增
					musician.setDesc("");
					musician.setDescUrl("");
					musician.setPicUrl5(sb.toString());
					musician.setUpdateBy(Constant.SYS_USER);
					musician.setCreateBy(Constant.SYS_USER);
					musician.setUpdateTime(date);
					musician.setCreateTime(date);
					musicianDao.add(musician);
				}
				else {
					//如果存在就更新
					musician = list.get(0);
					musician.setPicUrl5(sb.toString());
					musician.setUpdateTime(new Date());
					musicianDao.update(musician);
				}
			}
		}
	}
	
	public String getStringFromFile(File file) {
		try {
			StringBuilder sb = new StringBuilder();
			if (file.isFile() && file.exists()) {// 文件存在
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GB2312");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				while ((lineTxt = br.readLine()) != null) {
					if (!"".equals(lineTxt)) {
						sb.append(lineTxt);
					}
				}
				isr.close();
				br.close();
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
