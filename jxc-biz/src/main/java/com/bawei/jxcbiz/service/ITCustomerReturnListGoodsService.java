package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TCustomerReturnListGoods;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-03
 */
public interface ITCustomerReturnListGoodsService extends IService<TCustomerReturnListGoods> {


    boolean insertReturnGoods(TCustomerReturnListGoods tSaleListGoods);
}
