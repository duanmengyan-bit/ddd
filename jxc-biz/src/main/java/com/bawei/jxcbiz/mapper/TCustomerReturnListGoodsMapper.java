package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TCustomerReturnListGoods;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-03
 */
public interface TCustomerReturnListGoodsMapper extends BaseMapper<TCustomerReturnListGoods> {

    boolean insertReturnGoods(TCustomerReturnListGoods tSaleListGoods);
}
