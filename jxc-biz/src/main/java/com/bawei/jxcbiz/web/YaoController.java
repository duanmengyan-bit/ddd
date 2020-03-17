package com.bawei.jxcbiz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.entity.UserYao;
import com.bawei.jxcbiz.entity.Yao;
import com.bawei.jxcbiz.service.IUserYaoService;
import com.bawei.jxcbiz.service.IYaoService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.Dto.YaoDto;
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
@RequestMapping("/yao")
public class YaoController {

    @Autowired
    private IYaoService iYaoService;

    @Autowired
    private IUserYaoService iUserYaoService;

    @RequestMapping("/getList")
    public ResultEntity getList(){
        Wrapper wrapper = new EntityWrapper();
        List list = iYaoService.selectList(wrapper);
        return ResultEntity.ok(list);
    }

    @RequestMapping("/addYao")
    public ResultEntity addYao(YaoDto yaoDto){

        for(YaoDto yao : yaoDto.getSalelist()){
            UserYao userYao = new UserYao();
            userYao.setUid(14);
            userYao.setYid(yao.getId());
            iUserYaoService.insert(userYao);
            System.out.println(yao);
        }
        return ResultEntity.ok();
    }


}
