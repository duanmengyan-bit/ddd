package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.entity.TSaleList;
import com.bawei.jxcbiz.service.ITSaleListService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.Dto.TSaleListDto;

import com.bawei.jxccommon.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-02-20
 */
@RestController
@RequestMapping("/tSaleList")
public class TSaleListController {

    @Autowired
    private ITSaleListService itSaleListService;

    @RequestMapping("/getList")
    public ResultEntity getList(TSaleListDto tSaleListDto){

        List list = itSaleListService.getList(tSaleListDto);

        return ResultEntity.ok(list);
    }

    @RequestMapping("/addSaleList")//销售出库往t_sale_list表添加数据
    public ResultEntity addSaleList(TSaleList tSaleList) throws Exception {


        StringBuffer biilCodeStr=new StringBuffer();
        biilCodeStr.append("XS");
        biilCodeStr.append(DateUtil.getCurrentDateStr()); // 拼接当前日期
        for(int i=0;i<4;i++) {
            biilCodeStr.append(new Random().nextInt(9));
        }
        String saleNumber = biilCodeStr.toString();
        tSaleList.setSaleNumber(saleNumber);
        tSaleList.setUserId(1);

        boolean insert = itSaleListService.insertSale(tSaleList);
       return ResultEntity.ok("添加成功");
    }



}
