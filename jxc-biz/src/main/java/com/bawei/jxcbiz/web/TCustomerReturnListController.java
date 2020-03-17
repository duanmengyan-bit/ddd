package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.service.ITCustomerReturnListService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.Dto.TCustomerReturnListDto;
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
@RequestMapping("/tCustomerReturnList")
public class TCustomerReturnListController {

    @Autowired
    ITCustomerReturnListService itCustomerReturnListService;

    @RequestMapping("/getList")//客户退货查询
    public ResultEntity getList(TCustomerReturnListDto tCustomerReturnListDto){
        System.out.println(tCustomerReturnListDto);
        List list=itCustomerReturnListService.getList(tCustomerReturnListDto);
        return ResultEntity.ok(list);
    }

}
