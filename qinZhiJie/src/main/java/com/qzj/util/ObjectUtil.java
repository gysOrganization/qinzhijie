/*
 * 文 件 名:  ObjectUtil.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 对象转换工具
 * 
 * @author Muffler7
 * @version [版本号, 2018年10月27日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ObjectUtil {
	/**
	 * 将Map转换为对象
	 * 
	 * @param paramMap
	 * @param cls
	 * @return
	 */
	public static <T> T parseMap2Object(Map<String, Object> paramMap, Class<T> cls) {
		return JSONObject.parseObject(JSONObject.toJSONString(paramMap), cls);
	}

	/**
	 * 对象转换成Map
	 * 
	 * @param obj
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static HashMap<String, Object> ObjToMap(Object obj) throws Exception {
		HashMap<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		// 當前類屬性
		Field[] fields = obj.getClass().getDeclaredFields();
		// 父類屬性
		Field[] fieldcs = obj.getClass().getFields();

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals("serialVersionUID")) {
				continue;
			}
			Field f = obj.getClass().getDeclaredField(fields[i].getName());
			f.setAccessible(true);
			Object o = f.get(obj);
			if (o != null) {
				reMap.put(fields[i].getName(), o);
			}
		}

		for (int i = 0; i < fieldcs.length; i++) {

			if (fieldcs[i].getName().equals("gsId")) {
				continue;
			}

			Field f = obj.getClass().getField(fieldcs[i].getName());
			f.setAccessible(true);
			Object o = f.get(obj);
			if (o != null) {
				reMap.put(fieldcs[i].getName(), o);
			}
		}

		if (reMap.get("pageSize") != null && reMap.get("pageNo") != null) {
			int pageNo = Integer.valueOf(reMap.get("pageNo").toString());
			int pageSize = Integer.valueOf(reMap.get("pageSize").toString());
			reMap.put("pageNo", (pageNo - 1) * pageSize);
		}

		return reMap;
	}

}
