package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TSaleList;
import com.baomidou.mybatisplus.service.IService;
import com.bawei.jxcbiz.entity.Tsalelistuser;
import com.bawei.jxccommon.Dto.TSaleListDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2020-02-20
 */
public interface ITSaleListService extends IService<TSaleList> {

    List getList(TSaleListDto tSaleListDto);

    boolean insertSale(TSaleList tSaleListDto);



    int selectMaxId();
}
