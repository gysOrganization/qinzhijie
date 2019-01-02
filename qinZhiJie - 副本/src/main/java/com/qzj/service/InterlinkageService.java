/*
 * 文 件 名:  InterlinkageService.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月28日
 */
package com.qzj.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qzj.commos.exception.BizException;
import com.qzj.dto.Interlinkage;

/**
 * 友情链接业务
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class InterlinkageService extends BaseTgService {
	/**
	 * 新增
	 * 
	 * @param link
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public Map<String, Object> addLink(Interlinkage link) {
		if (StringUtils.isBlank(link.getName()) || StringUtils.isBlank(link.getUrl())
				|| StringUtils.isBlank(link.getType())) {
			throw new BizException("link name ,type or url is null", null, new HashMap<>());
		}

		link.setCreateTime(new Date());

		linkDao.addLink(link);

		return new HashMap<>();
	}

	/**
	 * <一句话功能简述> <功能详细描述>
	 * 
	 * @param link
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public Map<String, Object> updateLink(Interlinkage link) {
		if (StringUtils.isBlank(link.getName()) || StringUtils.isBlank(link.getUrl())
				|| StringUtils.isBlank(link.getType()) || (link.getId() != null && link.getId() <= 0)) {
			throw new BizException("link id, name ,type or url is null", null, new HashMap<>());
		}

		link.setCreateTime(null);
		link.setUpdateTime(new Date());

		int u = linkDao.updateLink(link);

		logger.info(" -- updateLink id --" + link.getId() + "  -- return " + u);

		return new HashMap<>();
	}

	/**
	 * 删除link
	 * 
	 * @param id
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public Map<String, Object> deleteLink(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("id is null", null, new HashMap<>());
		}

		int d = linkDao.deleteLink(id);

		logger.info(" -- deleteLink id --" + id + "  -- return " + d);

		return new HashMap<>();
	}

	/**
	 * 查询列表
	 * 
	 * @param map
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public List<Interlinkage> selectList(HashMap<String, Object> map) {
		String type = map.get("type") == null ? null : String.valueOf(map.get("type"));
		String name = map.get("name") == null ? null : String.valueOf(map.get("name"));
		String url = map.get("url") == null ? null : String.valueOf(map.get("url"));

		HashMap<String, Object> qmap = new HashMap<>();
		if (StringUtils.isNotBlank(type)) {
			qmap.put("type", type);
		}
		if (StringUtils.isNotBlank(name)) {
			qmap.put("name", name);
		}
		if (StringUtils.isNotBlank(url)) {
			qmap.put("url", url);
		}

		List<Interlinkage> list = linkDao.selectList(qmap);

		return list;
	}

}
