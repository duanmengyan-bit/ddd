package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.service.ITGoodsService;
import com.bawei.jxcbiz.service.ITGoodstypeService;
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
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/tGoodstype")
public class TGoodstypeController {

    @Autowired
    private ITGoodstypeService itGoodstypeService;

    @RequestMapping("/shu")
    public ResultEntity getList(){
        List list = itGoodstypeService.getTree();
        return ResultEntity.ok(list);
    }

}
