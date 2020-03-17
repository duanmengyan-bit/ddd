package com.bawei.jxcbiz.service;

import com.bawei.jxcbiz.entity.TSaleListGoods;
import com.baomidou.mybatisplus.service.IService;
import com.bawei.jxcbiz.entity.Tsalelistuser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2020-02-26
 */
public interface ITSaleListGoodsService extends IService<TSaleListGoods> {

    boolean insertSaleGoods(TSaleListGoods tSaleListGoods);


}
