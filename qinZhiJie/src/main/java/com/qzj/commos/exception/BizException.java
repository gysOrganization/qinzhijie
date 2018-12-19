package com.qzj.commos.exception;

public class BizException extends RuntimeException
{
    
    private static final long serialVersionUID = -5521621200054355113L;
    
    private String code;
    
    private Object data;
    
    public BizException(String code, Object data)
    {
        this.code = code;
        this.data = data;
    }
    
    public BizException(String message, String code, Object data)
    {
        super(message);
        this.code = code;
        this.data = data;
    }
    
    public BizException(String message, Throwable cause, String code, Object data)
    {
        super(message, cause);
        this.code = code;
        this.data = data;
    }
    
    public BizException(Throwable cause, String code, Object data)
    {
        super(cause);
        this.code = code;
        this.data = data;
    }
    
    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
        String code, Object data)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.data = data;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public Object getData()
    {
        return data;
    }
}
