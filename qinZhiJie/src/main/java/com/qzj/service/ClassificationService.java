/*
 * 文 件 名:  ClassificationService.java
 * 版    权:  LeYouYou Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Muffler7
 * 修改时间:  2018年10月27日
 */
package com.qzj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qzj.dto.Classification;

/**
 * 分类逻辑
 * 
 * @author  Muffler7
 * @version  [版本号, 2018年10月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class ClassificationService extends BaseTgService
{
    /**
     * 新增
     * @param a
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Classification addClassification(Classification a)
    {
        a.setCreateTime(new Date());
        classDao.addClassification(a);
        return a;
    }
    
    /**
     * 更新
     * @param a
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Classification updateById(Classification a)
    {
        a.setUpdateTime(new Date());
        classDao.updateById(a);
        return a;
    }
    
    /**
     * 删除
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int delte(Long id)
    {
        int i = classDao.deleteClassification(id);
        
        //查询子id 一并删除
        HashMap<String, Object>qmap = new HashMap<>();
        qmap.put("parentId", id);
        List<Classification> clsit= classDao.selectList(qmap);
        
        for(Classification c : clsit)
        {
            classDao.deleteClassification(c.getId());
        }
        
        return i;
    }
    
    /**
     * 查询分类
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Classification> getlist(HashMap<String, Object> map)
    {
        String sign = (map == null || map.get("sign")==null)?null:String.valueOf(map.get("sign"));
        List<Classification> counts = new ArrayList<>();
        //获取父菜单
        HashMap<String, Object> qmap = new HashMap<>();
        qmap.put("parentIdtemp", "parentIdtemp");
        List<Classification> parents = classDao.selectList(qmap);
        //获取子菜单
        
        if(parents==null||parents.isEmpty())
        {
            return  counts;
        }
        for(Classification c : parents)
        {
            HashMap<String, Object> smap = new HashMap<>();
            smap.put("parentId", c.getId());
            List<Classification>sons = classDao.selectList(smap);
            counts.add(c);
            for(Classification s : sons)
            {
                //页面标记 需要标记的话 子项名字前新增 --
                if(StringUtils.isNoneBlank(sign))
                {
                    s.setName("--"+s.getName());
                }
                counts.add(s);
            }
            
        }
      
        logger.info(" --  Classification getlist -- "+counts);
        
        return counts;
    }
    
    /**
     * 查询分类
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Classification> getlistByParam(HashMap<String, Object> map)
    {
        String sign = map.get("sign")==null?null:String.valueOf(map.get("sign"));
        String name = map.get("name")==null?null:String.valueOf(map.get("name"));
        String remark = map.get("remark")==null?null:String.valueOf(map.get("remark"));
        String parentIdtemp = map.get("parentIdtemp")==null?null:String.valueOf(map.get("parentIdtemp"));
        Integer parentId = map.get("parentId")==null?null:Integer.parseInt(String.valueOf(map.get("parentId")));
        
        HashMap<String, Object> qmap = new HashMap<>();
        if(StringUtils.isNotBlank(sign))
        {
            qmap.put("sign", sign);
        }
        if(StringUtils.isNotBlank(name))
        {
            qmap.put("name", name);
        }       
        if(StringUtils.isNotBlank(remark))
        {
            qmap.put("remark", remark);
        }
        if(StringUtils.isNotBlank(parentIdtemp))//查询一级类
        {
            qmap.put("parentIdtemp", parentIdtemp);
        }
        if(parentId!=null && parentId>0)
        {
            qmap.put("parentId", parentId);
        }
        List<Classification> counts =  classDao.selectList(qmap);
        
        for(Classification c : counts)
        {
            //页面标记 需要标记的话 子项名字前新增 --
            if(StringUtils.isNoneBlank(sign))
            {
                c.setName("--"+c.getName());
            }
        }
      
        logger.info(" --  Classification getlistByParam -- "+counts);
        
        return counts;
    }
    
}
