package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.TCustomerReturnList;
import com.bawei.jxcbiz.mapper.TCustomerReturnListMapper;
import com.bawei.jxcbiz.service.ITCustomerReturnListService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bawei.jxccommon.Dto.TCustomerReturnListDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-02-21
 */
@Service
public class TCustomerReturnListServiceImpl extends ServiceImpl<TCustomerReturnListMapper, TCustomerReturnList> implements ITCustomerReturnListService {


    @Override
    public List getList(TCustomerReturnListDto tCustomerReturnListDto) {
        return this.baseMapper.getList(tCustomerReturnListDto);
    }

    @Override
    public boolean insertt(TCustomerReturnList tSaleList) {
        return this.baseMapper.insertt(tSaleList);
    }

    @Override
    public int selectMaxId() {
        return this.baseMapper.selectMaxId();
    }
}
