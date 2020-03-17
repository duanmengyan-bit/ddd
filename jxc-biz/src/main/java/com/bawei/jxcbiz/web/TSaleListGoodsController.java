package com.bawei.jxcbiz.web;


import com.bawei.jxcbiz.entity.TGoods;
import com.bawei.jxcbiz.entity.TSaleList;
import com.bawei.jxcbiz.entity.TSaleListGoods;
import com.bawei.jxcbiz.entity.Tsalelistuser;
import com.bawei.jxcbiz.service.ITGoodsService;
import com.bawei.jxcbiz.service.ITSaleListGoodsService;
import com.bawei.jxcbiz.service.ITSaleListService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-02-26
 */
@RestController
@RequestMapping("/tSaleListGoods")
public class TSaleListGoodsController {

    @Autowired
    private ITSaleListGoodsService itSaleListGoodsService;

    @Autowired
    private ITGoodsService itGoodsService;


    @Autowired
    private ITSaleListService itSaleListService;

    @RequestMapping("/addSaleGoods")
    private ResultEntity addSaleGoods(Tsalelistuser tsalelistuser) throws Exception {
//        按照业务逻辑一个订单中一个人物，多条数据，传值为一个类
       System.out.println(tsalelistuser.getSalelist());

        for (TSaleListGoods tSaleListGoods : tsalelistuser.getSalelist()) {
            System.out.println("tSaleListGoods来了"+tSaleListGoods);
        }
//        添加出入记录的方法
       MYinsertSale(tsalelistuser);



        for (TSaleListGoods tSaleListGoods : tsalelistuser.getSalelist()) {
            System.out.println("234565434");
            tSaleListGoods.setPrice(tSaleListGoods.getSellingPrice());
            tSaleListGoods.setTotal(tSaleListGoods.getNum() * tSaleListGoods.getPrice());

            int id = itSaleListService.selectMaxId();

            tSaleListGoods.setSaleListId(id);
            tSaleListGoods.setGoodsId(tSaleListGoods.getId());
            TGoods tGoods = itGoodsService.selectById(tSaleListGoods.getId());
            tSaleListGoods.setTypeId(tGoods.getTypeId());
            boolean insert = itSaleListGoodsService.insertSaleGoods(tSaleListGoods);
        }
        return ResultEntity.ok();
    }

    private void MYinsertSale(Tsalelistuser tsalelistuser) throws Exception {
        TSaleList tSaleList = new TSaleList();
        BeanUtils.copyProperties(tsalelistuser, tSaleList);
        StringBuffer biilCodeStr = new StringBuffer();
        biilCodeStr.append("XS");
        biilCodeStr.append(DateUtil.getCurrentDateStr()); // 拼接当前日期
        for (int i = 0; i < 4; i++) {
            biilCodeStr.append(new Random().nextInt(9));
        }
        String saleNumber = biilCodeStr.toString();
        tSaleList.setSaleNumber(saleNumber);
        tSaleList.setUserId(1);

        boolean insert = itSaleListService.insertSale(tSaleList);
    }

}
