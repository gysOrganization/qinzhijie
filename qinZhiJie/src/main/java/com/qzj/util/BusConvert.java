package com.qzj.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.cglib.core.Converter;

public class BusConvert implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Object value, Class target, Object context) {
		if (value instanceof String) {
			return String.valueOf(value);
		} else if (value instanceof Byte) {
			return (Byte) value;
		} else if (value instanceof Short) {
			return (Short) value;
		} else if (value instanceof Double) {
			return (Double) value;
		} else if (value instanceof Float) {
			return (Float) value;
		} else if (value instanceof Long) {
			return (Long) value;
		} else if (value instanceof Integer) {
			return (Integer) value;
		} else if (value instanceof Boolean) {
			return (Boolean) value;
		} else if (value instanceof Date) {
			Date date = (Date) value;
			return DateUtils.dateToStrDefault(date);
		} else if (value instanceof List) {
			return (List) value;
		} else if (value instanceof Map) {
			return (Map) value;
		} else if (value instanceof int[]) {
			return (int[]) value;
		} else if (value instanceof Integer[]) {
			return (Integer[]) value;
		} else if (value instanceof String[]) {
			return (String[]) value;
		} else if (value instanceof long[]) {
			return (long[]) value;
		} else if (value instanceof Long[]) {
			return (Long[]) value;
		}

		return null;
	}

}
