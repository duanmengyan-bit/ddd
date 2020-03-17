package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TCustomerReturnList;
import com.baomidou.mybatisplus.service.IService;
import com.bawei.jxcbiz.entity.TSaleList;
import com.bawei.jxccommon.Dto.TCustomerReturnListDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
public interface ITCustomerReturnListService extends IService<TCustomerReturnList> {

    List getList(TCustomerReturnListDto tCustomerReturnListDto);

    boolean insertt(TCustomerReturnList tSaleList);

    int selectMaxId();
}
