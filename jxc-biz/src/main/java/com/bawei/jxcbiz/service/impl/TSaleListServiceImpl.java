package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.TSaleList;
import com.bawei.jxcbiz.mapper.TSaleListMapper;
import com.bawei.jxcbiz.service.ITSaleListService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bawei.jxccommon.Dto.TSaleListDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-02-20
 */
@Service
public class TSaleListServiceImpl extends ServiceImpl<TSaleListMapper, TSaleList> implements ITSaleListService {

    @Override
    public List getList(TSaleListDto tSaleListDto) {
        return this.baseMapper.getList(tSaleListDto);
    }

    @Override
    public boolean insertSale(TSaleList tSaleListDto) {
        return this.baseMapper.insertSale(tSaleListDto);
    }

    @Override
    public int selectMaxId() {
        return this.baseMapper.selectMaxId();
    }
}
