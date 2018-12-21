/*
 * 文 件 名:  InterlinkageController.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.dto.Interlinkage;
import com.qzj.util.ObjectUtil;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@CrossOrigin
@RestController
@RequestMapping("/link")
public class InterlinkageController extends BaseTgController {

	@RequestMapping("/add")
	public Map<String, Object> addLink(@RequestBody Map<String, Object> request) {
		Interlinkage link = ObjectUtil.parseMap2Object(request, Interlinkage.class);

		logger.info(" -- addLink --" + link);

		return linkService.addLink(link);
	}

	@RequestMapping("/update")
	public Map<String, Object> updateLink(@RequestBody Map<String, Object> request) {
		Interlinkage link = ObjectUtil.parseMap2Object(request, Interlinkage.class);

		logger.info(" -- updateLink --" + link);

		return linkService.updateLink(link);
	}

	@RequestMapping("/delete")
	public Map<String, Object> deleteLink(@RequestBody Map<String, Object> request) {
		Long id = request.get("id") == null ? null : Long.parseLong(String.valueOf(request.get("id")));

		logger.info(" -- deleteLink --" + id);

		return linkService.deleteLink(id);
	}

	@RequestMapping("/getlist")
	public List<Interlinkage> selectList(@RequestBody Map<String, Object> request) {
		HashMap<String, Object> map = new HashMap<>(request);

		logger.info(" -- selectLinkList --" + map);

		return linkService.selectList(map);
	}

}
