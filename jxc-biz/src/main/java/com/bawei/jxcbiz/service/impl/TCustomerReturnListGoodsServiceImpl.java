package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.TCustomerReturnListGoods;
import com.bawei.jxcbiz.mapper.TCustomerReturnListGoodsMapper;
import com.bawei.jxcbiz.service.ITCustomerReturnListGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-03
 */
@Service
public class TCustomerReturnListGoodsServiceImpl extends ServiceImpl<TCustomerReturnListGoodsMapper, TCustomerReturnListGoods> implements ITCustomerReturnListGoodsService {


    @Override
    public boolean insertReturnGoods(TCustomerReturnListGoods tSaleListGoods) {
        return this.baseMapper.insertReturnGoods(tSaleListGoods);
    }
}
