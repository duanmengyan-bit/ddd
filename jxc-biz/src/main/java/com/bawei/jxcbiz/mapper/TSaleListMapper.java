package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TSaleList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bawei.jxccommon.Dto.TSaleListDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-02-20
 */
public interface TSaleListMapper extends BaseMapper<TSaleList> {

    List getList(TSaleListDto tSaleListDto);

    boolean insertSale(TSaleList tSaleListDto);

    int selectMaxId();
}
