package com.qzj.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.vo.ResponseData;
import com.qzj.dto.BigPicture;
import com.qzj.dto.PageRequest;
import com.qzj.dto.PageResult;
import com.qzj.service.PictureService;

/**
 * 会员管理接口
 * 
 * @author YuanSongGong
 *
 */
@RestController
@RequestMapping("/bigPicture")
public class PictureController extends BaseTgController {

	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public ResponseData<PageResult<BigPicture>> getList(@RequestBody PageRequest page, HttpServletRequest request) {
		ResponseData<PageResult<BigPicture>> result = new ResponseData<PageResult<BigPicture>>();
		result.setData(pictureService.getList(page));
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData<PageResult<BigPicture>> add(@RequestBody BigPicture Picture, HttpServletRequest request) {
		ResponseData<PageResult<BigPicture>> result = new ResponseData<PageResult<BigPicture>>();
		pictureService.add(Picture);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseData<PageResult<BigPicture>> update(@RequestBody BigPicture Picture, HttpServletRequest request) {
		ResponseData<PageResult<BigPicture>> result = new ResponseData<PageResult<BigPicture>>();
		pictureService.update(Picture);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseData<PageResult<BigPicture>> delete(@RequestParam String ids, HttpServletRequest request) {
		ResponseData<PageResult<BigPicture>> result = new ResponseData<PageResult<BigPicture>>();
		pictureService.delete(ids);
		result.setCode("200");
		result.setMessage("Success");
		return result;
	}
}
