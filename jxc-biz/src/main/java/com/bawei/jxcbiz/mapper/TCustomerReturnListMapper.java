package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TCustomerReturnList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bawei.jxccommon.Dto.TCustomerReturnListDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface TCustomerReturnListMapper extends BaseMapper<TCustomerReturnList> {

    List getList(TCustomerReturnListDto tCustomerReturnListDto);

    boolean insertt(TCustomerReturnList tSaleList);

    int selectMaxId();
}
