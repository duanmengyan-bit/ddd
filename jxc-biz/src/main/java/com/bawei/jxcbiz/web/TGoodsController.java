package com.bawei.jxcbiz.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bawei.jxcbiz.entity.TGoods;
import com.bawei.jxcbiz.service.ITGoodsService;
import com.bawei.jxccommon.Dto.ResultEntity;
import com.bawei.jxccommon.Dto.TGoodsDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.beans.IntrospectionException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/tGoods")
@Slf4j
public class TGoodsController {

    @Autowired
    ITGoodsService itGoodsService;

    @RequestMapping("/getGoodsPage")
    public ResultEntity getGoodsPage(TGoodsDto goodsDto){
        PageHelper.startPage(goodsDto.getPageNo(),goodsDto.getPageSize());
        Wrapper wrapper = new EntityWrapper();
        if (StringUtils.isNotBlank(goodsDto.getName())){
            wrapper.like("name",goodsDto.getName());
        }
        List<TGoods> list = itGoodsService.selectList(wrapper);
        PageInfo<TGoods> pageInfo  = new PageInfo<TGoods>(list);
        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/downLoadGoodsExcel")
    public ResponseEntity downLoadGoodsExcel(TGoodsDto goodsDto) throws IOException, ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {

        XSSFWorkbook xSSFWorkbooks = itGoodsService.downLoadGoodsExcel(goodsDto);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xSSFWorkbooks.write(byteArrayOutputStream);

        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", new String("商品表.xlsx".getBytes("UTF-8"), "ISO-8859-1"));
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity(byteArrayOutputStream.toByteArray(),httpHeaders, HttpStatus.CREATED);

    }

    List<String> excelname = Arrays.asList(".xls",".xlsx");
    @RequestMapping("/upLoadExcel")
    public ResultEntity upLoadExcel(MultipartFile file) throws Exception {
        if (file==null){
            throw new Exception("文件为空");
        }

        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if (!excelname.contains(fileType)){
            throw new Exception("只能导入excel格式的文件");
        }

        try {
            this.itGoodsService.uplodExcel(file);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            throw new Exception("导入数据失败");
        }
        return ResultEntity.ok("导入数据成功");
    }

    @RequestMapping("/getList")
    public ResultEntity getList(TGoodsDto tGoodsDto) {
        PageHelper.startPage(tGoodsDto.getPageNo(), tGoodsDto.getPageSize());
        List list = itGoodsService.getList(tGoodsDto);
        PageInfo info = new PageInfo(list);
        return ResultEntity.ok(info);
    }

    @RequestMapping("/getGoods")//
    public ResultEntity getGoods(TGoodsDto tGoodsDto) {
        PageHelper.startPage(tGoodsDto.getPageNo(), tGoodsDto.getPageSize());
        Wrapper wrapper = new EntityWrapper();
        if (tGoodsDto.getJie() != null && tGoodsDto.getJie() != "") {
            wrapper.eq("code", tGoodsDto.getJie()).or().like("name", tGoodsDto.getJie());
        }
        List list = itGoodsService.selectList(wrapper);
        PageInfo info = new PageInfo(list);
        return ResultEntity.ok(info);
    }

    @RequestMapping("/getGoodsById")//根据商品类型来查找商品
    public ResultEntity getGoodsById(TGoodsDto tGoodsDto) {
        PageHelper.startPage(tGoodsDto.getPageNo(), tGoodsDto.getPageSize());
        List list = itGoodsService.getGoods(tGoodsDto.getTypeId());
        PageInfo info = new PageInfo(list);
        return ResultEntity.ok(info);
    }

    @RequestMapping("/getAddGoods")
    public ResultEntity getGoods(int id) {
        TGoods tGoods = itGoodsService.selectById(id);
        return ResultEntity.ok(tGoods);
    }


}
