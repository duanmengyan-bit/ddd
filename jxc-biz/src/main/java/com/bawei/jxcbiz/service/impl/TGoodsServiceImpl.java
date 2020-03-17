package com.bawei.jxcbiz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.entity.TGoods;
import com.bawei.jxcbiz.mapper.TGoodsMapper;
import com.bawei.jxcbiz.service.ITGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bawei.jxccommon.Dto.TGoodsDto;
import com.bawei.jxccommon.util.ExcelBean;
import com.bawei.jxccommon.util.ExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements ITGoodsService {

    @Override
    public List getList(TGoodsDto tGoodsDto) {
        return this.baseMapper.getList(tGoodsDto);
    }

    @Override
    public List getGoods(Integer typeId) {
        return this.baseMapper.getGoods(typeId);
    }

    @Override
    public XSSFWorkbook downLoadGoodsExcel(TGoodsDto goodsDto) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        PageHelper.startPage(goodsDto.getPageNo(),goodsDto.getPageSize());
        Wrapper wrapper = new EntityWrapper();

        if (StringUtils.isNotBlank(goodsDto.getName())){
            wrapper.like("name",goodsDto.getName());
        }

        List<TGoods> list = this.selectList(wrapper);
        PageInfo<TGoods> pageInfo = new PageInfo(list);
        Map<Integer,List<ExcelBean>> map = new HashMap<Integer,List<ExcelBean>>();
        List<ExcelBean> excelBeans = new ArrayList<>();
        excelBeans.add(new ExcelBean("id","id",0));
        excelBeans.add(new ExcelBean("商品名称","name",0));
        excelBeans.add(new ExcelBean("商品代码","code",0));
        excelBeans.add(new ExcelBean("库存","inventoryQuantity",0));
        excelBeans.add(new ExcelBean("商品样式","model",0));
        excelBeans.add(new ExcelBean("生产商","producer",0));
        excelBeans.add(new ExcelBean("采购价格","purchasingPrice",0));
        excelBeans.add(new ExcelBean("销售价格","sellingPrice",0));
        excelBeans.add(new ExcelBean("最后成交价","lastPurchasingPrice",0));

        excelBeans.add(new ExcelBean("单位","unit",0));
        excelBeans.add(new ExcelBean("状态","stateStr",0));
        map.put(0,excelBeans);
        return ExcelUtils.createExcelFile(TGoods.class,pageInfo.getList(),map,"商铺列表");
    }

    @Override
    public void uplodExcel(MultipartFile file) throws Exception {
        List<List<Object>> bankListByExcel = ExcelUtils.getBankListByExcel(file.getInputStream(), file.getOriginalFilename());
        List<TGoods> list = new ArrayList<>();

        for (List<Object> objects : bankListByExcel) {
            TGoods goods = new TGoods();
            goods.setName(objects.get(1).toString());
            goods.setCode(objects.get(2).toString());
            goods.setInventoryQuantity(Integer.valueOf(objects.get(3).toString()));
            goods.setModel(objects.get(4).toString());
            goods.setProducer(objects.get(5).toString());
            goods.setPurchasingPrice(Float.valueOf(objects.get(6).toString()));
            goods.setSellingPrice(Float.valueOf(objects.get(7).toString()));
            goods.setLastPurchasingPrice(Float.valueOf(objects.get(8).toString()));
            goods.setUnit(objects.get(9).toString());
            goods.setState(objects.get(10).toString().equals("上架")?2:0);
            goods.setMinNum(100);
            list.add(goods);
        }
        this.insertBatch(list);
    }
}
