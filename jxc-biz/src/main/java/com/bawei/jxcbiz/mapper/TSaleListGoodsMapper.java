package com.bawei.jxcbiz.mapper;

import com.bawei.jxcbiz.entity.TSaleListGoods;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2020-02-26
 */
public interface TSaleListGoodsMapper extends BaseMapper<TSaleListGoods> {

    boolean insertSaleGoods(TSaleListGoods tSaleListGoods);
}
