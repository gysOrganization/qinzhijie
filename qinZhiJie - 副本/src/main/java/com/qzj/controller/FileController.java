package com.qzj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.PageResult;
import com.qzj.service.FileService;

/**
 * 会员管理接口
 * 
 * @author YuanSongGong
 *
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseTgController {

	@Value("${uploadDir}")
	private String uploadDir;

	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam(value = "uuid") String uuid, HttpServletRequest request, HttpServletResponse response) {
		fileService.download(uuid, response);
	}

	//TODO
	//还有一个中文乱码的问题，后面解决
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseData<PageResult<String>> upload(@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request) {
		return fileService.upload(file, uploadDir);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseData<PageResult<String>> delete(@RequestParam(value = "uuid") String uuid,
			HttpServletRequest request) {
		return fileService.delete(uuid);
	}
}
