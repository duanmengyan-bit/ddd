package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.TSaleListGoods;
import com.bawei.jxcbiz.mapper.TSaleListGoodsMapper;
import com.bawei.jxcbiz.service.ITSaleListGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-02-26
 */
@Service
public class TSaleListGoodsServiceImpl extends ServiceImpl<TSaleListGoodsMapper, TSaleListGoods> implements ITSaleListGoodsService {

    @Override
    public boolean insertSaleGoods(TSaleListGoods tSaleListGoods) {
        return this.baseMapper.insertSaleGoods(tSaleListGoods);
    }
}
