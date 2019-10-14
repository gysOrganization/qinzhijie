package com.qzj.controller;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.coobird.thumbnailator.Thumbnails;

@CrossOrigin
@RestController
@RequestMapping("/pic")
public class PicDownloadController {

	@Value("${picFileDir}")
	private String uploadDir;
	// 文件下载相关代码
	@RequestMapping(value = "/downloadImage", method = RequestMethod.GET)
	public void downloadImage(@RequestParam(value = "path") String path,
			@RequestParam(value = "scale", defaultValue = "1f", required = false) double scale,
			@RequestParam(value = "quality", defaultValue = "1f", required = false) double quality,
			HttpServletRequest request, HttpServletResponse response) {
		String fileUrl = uploadDir + path;
		try {
			if (fileUrl != null) {
				File file = new File(fileUrl);
				if (file.exists()) {
					OutputStream os = response.getOutputStream();
					// 图片大小和质量压缩
					Thumbnails.of(fileUrl).scale(scale).outputQuality(quality).toOutputStream(os);
					response.setContentType("application/force-download");// 设置强制下载不打开
					response.addHeader("Content-Disposition", "attachment;fileName=" +
							path.substring(path.lastIndexOf("/") + 1, path.length()));// 设置文件名
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
