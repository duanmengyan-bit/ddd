package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.service.INationService;
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
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private INationService iNationService;

    @RequestMapping("/getList")
    public ResultEntity getList(){
        List list= iNationService.getList();
        return ResultEntity.ok(list);
    }

}
