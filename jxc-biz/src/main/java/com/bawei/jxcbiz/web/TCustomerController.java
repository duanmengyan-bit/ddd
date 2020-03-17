package com.bawei.jxcbiz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.service.ITCustomerService;
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
 * @author Mht
 * @since 2020-02-20
 */
@RestController
@RequestMapping("/tCustomer")
public class TCustomerController {

    @Autowired
    private ITCustomerService itCustomerService;

    @RequestMapping("/getList")
    public ResultEntity getList(){
        Wrapper wrapper = new EntityWrapper();
        List list = itCustomerService.selectList(wrapper);
        return ResultEntity.ok(list);
    }

}
