package com.qzj.commos.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qzj.commos.exception.BizException;
import com.qzj.commos.vo.ResponseData;

@ControllerAdvice
public class ExceptionResolver {
	@ResponseBody
	@ExceptionHandler(value = BizException.class)
	public ResponseData<Object> resolveBiz(BizException e) {
		ResponseData<Object> responseData = new ResponseData<>();
		responseData.setMessage(e.getMessage());
		responseData.setCode(e.getCode() == null ? "-1" : e.getCode());
		responseData.setData(e.getData());
		return responseData;
	}

	@ResponseBody
	@ExceptionHandler(value = Throwable.class)
	public ResponseData<Object> resolveThrowable(Throwable e) {
		e.printStackTrace();
		ResponseData<Object> responseData = new ResponseData<>();
		responseData.setMessage(e.getMessage());
		responseData.setCode("-1");
		return responseData;
	}
}
