package com.qzj.entity;

import java.io.Serializable;
import java.util.Date;

import com.qzj.entity.BaseTgEntity;

import lombok.Data;

@Data
public class BaseTgEntity implements Serializable
{
    private static final long serialVersionUID = 4353881782501900516L;
    
    /**主键优惠ID*/
    private Long id;
    
    /**创建时间*/
    private Date createTime;
    
    /**修改时间*/
    private Date updateTime;
    
}
