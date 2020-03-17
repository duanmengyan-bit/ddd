package com.bawei.jxcbiz.service.impl;

import com.bawei.jxcbiz.entity.TGoodstype;
import com.bawei.jxcbiz.mapper.TGoodstypeMapper;
import com.bawei.jxcbiz.service.ITGoodstypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class TGoodstypeServiceImpl extends ServiceImpl<TGoodstypeMapper, TGoodstype> implements ITGoodstypeService {

    @Override
    public List getTree() {
        return this.baseMapper.getTree();
    }
}
