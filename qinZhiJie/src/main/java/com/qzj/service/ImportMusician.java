package com.qzj.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzj.commos.Constant;
import com.qzj.dao.MusicianDao;
import com.qzj.dto.Musician;

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
