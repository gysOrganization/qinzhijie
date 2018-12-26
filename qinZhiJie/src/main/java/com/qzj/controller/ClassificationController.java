/*
 * 文 件 名:  ClassificationController.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.commos.exception.BizException;
import com.qzj.dto.Classification;
import com.qzj.util.ObjectUtil;

/**
 * 分类管理
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@CrossOrigin
@RestController
@RequestMapping("/classification")
public class ClassificationController extends BaseTgController {

	@RequestMapping("/add")
	public Classification add(@RequestBody Map<String, Object> request) {
		Classification c = ObjectUtil.parseMap2Object(request, Classification.class);

		logger.info(" -- add Classification --" + c);

		return classService.addClassification(c);
	}

	@RequestMapping("/update")
	public Classification update(@RequestBody Map<String, Object> request) {
		Classification c = ObjectUtil.parseMap2Object(request, Classification.class);

		logger.info(" -- update Classification --" + c);

		return classService.updateById(c);
	}

	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestBody Map<String, Object> request) {
		Long id = request.get("id") == null ? null : Long.parseLong(String.valueOf(request.get("id")));

		Map<String, Object> map = new HashMap<>();

		if (id == null || id <= 0) {
			throw new BizException("id is erro", null, map);
		}

		int d = classService.delte(id);

		logger.info(" -- delete Classification --" + id + "  -- return " + d);

		return map;
	}

	@RequestMapping("/getlist")
	public List<Classification> getlist(@RequestBody(required = false) Map<String, Object> request) {
		HashMap<String, Object> map = null;
		if (request != null) {
			map = new HashMap<>(request);
		}

		logger.info(" --  Classification getlist -- request" + request);

		return classService.getlist(map);
	}

	@RequestMapping("/getlistbyparam")
	public List<Classification> getlistByParam(@RequestBody Map<String, Object> request) {
		HashMap<String, Object> map = new HashMap<>(request);

		logger.info(" --  Classification getlist -- request" + request);

		return classService.getlistByParam(map);
	}

}
