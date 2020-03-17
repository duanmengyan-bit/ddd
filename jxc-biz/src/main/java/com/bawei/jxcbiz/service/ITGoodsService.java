package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TGoods;
import com.baomidou.mybatisplus.service.IService;
import com.bawei.jxccommon.Dto.TGoodsDto;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface ITGoodsService extends IService<TGoods> {

    List getList(TGoodsDto tGoodsDto);

    List getGoods(Integer typeId);

    XSSFWorkbook downLoadGoodsExcel(TGoodsDto goodsDto) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

    void uplodExcel(MultipartFile file) throws Exception;
}
