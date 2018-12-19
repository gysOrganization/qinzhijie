package com.qzj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qzj.dto.LoggerTest;


@RestController
@RequestMapping("/logger")
public class LoggerController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/x")
    public LoggerTest xslsheet()
    {
        logger.trace("I am trace log.");
        logger.debug("I am debug log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.");
        LoggerTest l = new LoggerTest();
        l.setMsg("hello logger");
        
        return l;
    }
    
}
