package com.qzj.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.BookDao;
import com.qzj.dao.BookDetailDao;
import com.qzj.dao.MusicianDao;
import com.qzj.dto.Book;
import com.qzj.dto.BookDetail;
import com.qzj.dto.Musician;
import com.qzj.dto.PageRequest;

@Service
public class ImportService {

	@Autowired
	private MusicianDao musicianDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookDetailDao bookDetailDao;
	
	@Value("${basePath}")
	private String basePath;

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
	
	public void importBookAll() {
		List<String> list = new ArrayList<>();
		//一下add的注释的都需要特殊处理
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\02第二册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\03第三册 已審");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\05第五册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\06第六册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\07第七册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\08册   审核OK  成龙");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\09第九册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\10第十册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\11第十一册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\12第十二册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\14第十四册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\15第十五册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\16册修整\\16第十六册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\17第十七册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\18第十八册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\19第十九册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\20第二十册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\21第二十一册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\22第二十二册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\23第二十三册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\24第二十四 已審完");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\25第二十五册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\26第二十六册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\27第二十七册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\28 第二十八册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\29第二十九册  已审核  成龙");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\30第三十册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\31");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\31第三十一册琴谱合璧");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\32第三十二册 琴史");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\33第三十三册 琴學");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\34第三十四册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\35第三十五册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\36第三十六册\\琴学汇成");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\37第三十七册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\38第三十八册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\39第三十九册");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\40第四十册琴府");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\41第四十一册");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\42第四十二");
		list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\43第四十三");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\古指法考---管平湖");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\碣石调幽兰");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\清湖琴谱");
		//特殊处理 list.add(basePath + "01资料馆\\03历代琴谱\\02修图完成\\媛媛");
		for(String path : list) {
			ipmortBook(path);
		}
	}
	
	
	
	//将  （G:\工作2019\01资料馆\03历代琴谱\02修图完成）导入到数据库,分成两步骤
	//第一：先导入到book中
	//第二：在导入每本书中的所有章节
	public void ipmortBook(String path) {
		File p = new File(path);
		if(!p.exists() || !p.isDirectory()) {
			System.out.println("路径有问题");
		}
		Date date = new Date();
		for(String subPath : p.list()) {
			File sub = new File(path + "\\" + subPath);
			
			String bookName = subPath.replaceAll("\\d+","").trim();
			
			
			int maxId = bookDao.selectMaxId();
			Book book = new Book();
			book.setId(new Long(maxId + 1));
			book.setBookName(bookName);
			book.setDirPath(sub.getAbsolutePath().replace(basePath, ""));
			book.setUpdateBy(Constant.SYS_USER);
			book.setCreateBy(Constant.SYS_USER);
			book.setUpdateTime(date);
			book.setCreateTime(date);
			//插入book数据
			bookDao.add(book);
			if(sub.isDirectory()) {
				for(String partPath : sub.list()) {
					File f = new File(path + "\\" + subPath + "\\" + partPath);
					if(f.isDirectory()) {
						
						String partName = "";
						if(partPath.contains("-")) {
							partName = partPath.substring(partPath.lastIndexOf("-") + 1, partPath.length()).trim();
						}else {
							partName = partPath.replaceAll("\\d", "");
						}
						BookDetail bookDetail = new BookDetail();
						bookDetail.setBookId(book.getId().intValue());
						bookDetail.setDirPath(f.getAbsolutePath().replace(basePath, ""));
						bookDetail.setPartName(partName);
						bookDetail.setOrderNum(getNumFromStr(partPath));
						bookDetail.setUpdateBy(Constant.SYS_USER);
						bookDetail.setCreateBy(Constant.SYS_USER);
						bookDetail.setUpdateTime(date);
						bookDetail.setCreateTime(date);
						try {
							//插入bookDetail数据
							bookDetailDao.add(bookDetail);
						}catch(Exception e) {
							//这个路径导入有误：
							//01资料馆\\03历代琴谱\\02修图完成\\20第二十册\\4指法滙参确解\\53法滙参确解 ---绒৯法
							System.out.println("这个路径导入有误：" + bookDetail.getDirPath());
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	//获取字符串中的数字
	public Integer getNumFromStr(String str) {
		String[] list = str.split("-");
		str = list[0];
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(str); 
		String returnStr = m.replaceAll("").trim();
		return new Integer(StringUtils.isBlank(returnStr) ? "-1" : returnStr);
		}
	
	public static void main(String[] args) {
	}
}
