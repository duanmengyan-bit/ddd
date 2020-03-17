package com.bawei.jxcbiz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.entity.HUser;
import com.bawei.jxcbiz.service.IHUserService;
import com.bawei.jxccommon.Dto.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/hUser")
public class HUserController {

    @Autowired
    private IHUserService ihUserService;

    @RequestMapping("/getList")
    public ResultEntity getList(){
        Wrapper wrapper = new EntityWrapper();
        List list = ihUserService.selectList(wrapper);
        return ResultEntity.ok(list);
    }

    @RequestMapping("/getMo")
    private ResultEntity getMo(HUser user){

        HUser user1 = ihUserService.getList(user);
        return ResultEntity.ok(user1);
    }

    @RequestMapping("/addObject")
    public ResultEntity addObject(HUser user){
        System.out.println(user);
      boolean insert = ihUserService.insert(user);
        return ResultEntity.ok("添加成功");
    }

}
