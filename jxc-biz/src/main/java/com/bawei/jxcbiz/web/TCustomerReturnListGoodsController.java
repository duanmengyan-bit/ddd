package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.entity.*;
import com.bawei.jxcbiz.service.ITCustomerReturnListGoodsService;
import com.bawei.jxcbiz.service.ITCustomerReturnListService;
import com.bawei.jxcbiz.service.ITGoodsService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/tCustomerReturnListGoods")
public class TCustomerReturnListGoodsController {

    @Autowired
    private ITCustomerReturnListService itCustomerReturnListService;

    @Autowired
    private ITCustomerReturnListGoodsService itCustomerReturnListGoodsService;

    @Autowired
    private ITGoodsService itGoodsService;

    @RequestMapping("/addReturnGoods")
    private ResultEntity addSaleGoods(TCustomerListGoodsDto tsalelistuser) throws Exception {
//        按照业务逻辑一个订单中一个人物，多条数据，传值为一个类
        System.out.println(tsalelistuser.getSalelist());


//        添加出入记录的方法
        MYinsertSale(tsalelistuser);



        for (TCustomerReturnListGoods tSaleListGoods : tsalelistuser.getSalelist()) {
            System.out.println("234565434");
           tSaleListGoods.setPrice(tSaleListGoods.getSellingPrice());
            tSaleListGoods.setTotal(tSaleListGoods.getNum() * tSaleListGoods.getPrice());

            int id = itCustomerReturnListService.selectMaxId();

            tSaleListGoods.setCustomerReturnListId(id);
            tSaleListGoods.setGoodsId(tSaleListGoods.getId());
            TGoods tGoods = itGoodsService.selectById(tSaleListGoods.getId());
            tSaleListGoods.setTypeId(tGoods.getTypeId());
            boolean insert = itCustomerReturnListGoodsService.insertReturnGoods(tSaleListGoods);
        }
        return ResultEntity.ok();
    }

    private void MYinsertSale(TCustomerListGoodsDto tsalelistuser) throws Exception {
        TCustomerReturnList tSaleList = new TCustomerReturnList();
        BeanUtils.copyProperties(tsalelistuser, tSaleList);
        StringBuffer biilCodeStr = new StringBuffer();
        biilCodeStr.append("XS");
        biilCodeStr.append(DateUtil.getCurrentDateStr()); // 拼接当前日期
        for (int i = 0; i < 4; i++) {
            biilCodeStr.append(new Random().nextInt(9));
        }
        String saleNumber = biilCodeStr.toString();
        tSaleList.setCustomerReturnNumber(saleNumber);
        tSaleList.setUserId(1);

        boolean insert = itCustomerReturnListService.insertt(tSaleList);
    }

}
