package com.bawei.jxcbiz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.service.IFeiService;
import com.bawei.jxccommon.Dto.ResultEntity;
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
 * @since 2020-03-16
 */
@RestController
@RequestMapping("/fei")
public class FeiController {

    @Autowired
    IFeiService iFeiService;

    @RequestMapping("/getList")
    private ResultEntity getList(){
        Wrapper wrapper = new EntityWrapper();
        List list = iFeiService.selectList(wrapper);
        return ResultEntity.ok(list);
    }

}
