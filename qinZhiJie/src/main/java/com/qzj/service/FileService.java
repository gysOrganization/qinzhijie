package com.qzj.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qzj.commos.Constant;
import com.qzj.commos.vo.ResponseData;
import com.qzj.dao.FileDao;
import com.qzj.dto.FileBean;
import com.qzj.dto.PageResult;

@Service
public class FileService {

	@Autowired
	private FileDao fileDao;

	public ResponseData<PageResult<String>> upload(MultipartFile file, String uploadDir) {
		ResponseData<PageResult<String>> result = new ResponseData<PageResult<String>>();
		if (file.isEmpty()) {
			result.setMessage("文件不能为空");
		}
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		// 文件类型
		String fileType = file.getContentType();
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		// 文件上传后的路径
		String filePath = uploadDir + uuid + suffixName;
		// 创建file对象
		File dest = new File(filePath);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			FileBean f = new FileBean();
			f.setUuid(uuid);
			f.setFileType(fileType);
			f.setName(fileName);
			f.setPath(filePath);
			f.setCreateBy(Constant.SYS_USER);
			f.setCreateTime(new Date());
			f.setUpdateBy(Constant.SYS_USER);
			f.setUpdateTime(new Date());
			// 插入数据库表
			fileDao.add(f);
			result.setCode("200");
			result.setMessage(uuid);
			return result;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.setCode("200");
		result.setMessage("error");
		return result;
	}

	public void download(String uuid, HttpServletResponse response) {
		FileBean fileBean = fileDao.getByUuid(uuid);
		if (fileBean == null || StringUtils.isBlank(fileBean.getPath()) || StringUtils.isBlank(fileBean.getName())) {
			return;
		}
		// 1.获取要下载的文件的绝对路径
		File file = new File(fileBean.getPath());
		// 2.获取要下载的文件名
		String fileName = fileBean.getName();
		// 3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		// 4.根据文件路径获取要下载的文件输入流
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int len = 0;
			// 5.创建数据缓冲区
			byte[] buffer = new byte[1024];
			// 6.通过response对象获取OutputStream流
			OutputStream out = response.getOutputStream();
			// 7.将FileInputStream流写入到buffer缓冲区
			while ((len = in.read(buffer)) > 0) {
				// 8.使用OutputStream将缓冲区的数据输出到客户端浏览器
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ResponseData<PageResult<String>> delete(String uuid) {
		ResponseData<PageResult<String>> result = new ResponseData<>();
		result.setCode("200");
		FileBean fileBean = fileDao.getByUuid(uuid);
		if (fileBean == null || StringUtils.isBlank(fileBean.getPath()) || StringUtils.isBlank(fileBean.getName())) {
			return result;
		}
		//文件删除
		File f = new File(fileBean.getPath());
		if(f.exists()) {
			f.delete();
		}
		//记录删除
		ArrayList<String> list = new ArrayList<>();
		list.add(uuid);
		fileDao.delete(list);
		result.setMessage("Success");
		return result;
	}
}
