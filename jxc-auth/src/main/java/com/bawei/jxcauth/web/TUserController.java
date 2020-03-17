package com.bawei.jxcauth.web;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcauth.service.ITUserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/tUser")
@Slf4j
public class TUserController {

    @Autowired
    private ITUserService itUserService;

    @RequestMapping("/list")
    public String test(){
        Wrapper wrapper = new EntityWrapper();
        List list = itUserService.selectList(wrapper);
        log.info("list:{}", JSON.toJSONString(list));
        return "";
    }

}
